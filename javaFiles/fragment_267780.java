String TABLE_NAME = "yourTable";
StringBuilder sb = new StringBuilder("INSERT INTO ");
sb.append(TABLE_NAME).append(" (");

rs = stmt.executeQuery(query);
rsmd = rs.getMetaData();
int columnsNumber = rsmd.getColumnCount();
for (int i=0; i < columnsNumber; ++i) {
    String name = rsmd.getColumnName(i+1);
    if (i > 0) {
        sb.append(", ");
    }
    sb.append(name);
}
sb.append(")\nVALUES\n");

// now generate rows
boolean start = true;
while (rs.next()) {
    if (start) {
        start = false;
    }
    else {
        sb.append(",\n");
    }
    sb.append("(");
    for (int i=0; i < columnsNumber; i++) {
        if (i > 0) {
            sb.append(", ");
        }
        String columnValue = rs.getString(i+1);
        sb.append(columnValue);
    }
    sb.append(")");
}

sb.append(";");