public void process(java.util.Date fromDate) {
    RowSet rows = <run query with fromDate as parameter>
    while (rows.nsxt()) {
        java.sql.Date date = rows.getDate(1);
        // code that needs date
    }
}