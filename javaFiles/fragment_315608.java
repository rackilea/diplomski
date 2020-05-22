Polygon givenPolygon = getInputPolygon();

// open source and get data with JDBC
Connection c = DriverManager.getConnection(src);
Statement s = c.createStatement();
ResultSet results = s.executeQuery("SELECT * FROM " + table);

// open dest and copy/filter with jackcess
Database destDB = Database.open(dest);
destDB.copyTable(table, results, new ImportFilter() {
    @Override
    public List<Column> filterColumns(List<Column> cols,
                                      ResultSetMetaData metadata)
    throws SQLException, IOException {
        // get all columns
        return cols;
    }

    @Override
    public Object[] filterRow(Object[] row) throws SQLException,
    IOException {
        byte[] blob = row[1]; // or whatever your schema requires
        Polygon p = new Polygon(blob);
        if givenPolygon.intersects(p)
            return row;
        return null;
    }
});