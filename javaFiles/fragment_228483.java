ResultSet rs = conn.getMetaData().getColumns("", "%", "{TABLENAME}", "{COLUMNNAME}");

if(!rs.next()) {
    // unknown table/column
}

int precision = rs.getInt("COLUMN_SIZE");
int scale = rs.getInt("DECIMAL_DIGITS");