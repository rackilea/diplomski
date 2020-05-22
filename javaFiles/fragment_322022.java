StringBuilder sb = new StringBuilder(a.length * 2);
for(byte b: data) {
    sb.append(String.format("%02x", b));
}
String sql = "INSERT INTO myTable (column1, column2, column3) "
           + "VALUES (1, 'hello world', x'" + sb.toString() + "');";