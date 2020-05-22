Class.forName(driver);
conn = DriverManager.getConnection(url+db, user, pass);
Statement st = conn.createStatement();
String zero = dates.getSelectedItem().toString();
String sql = "select fruits,price from fruitstable";
pst=conn.prepareStatement(sql);
rs=pst.executeQuery();

Table table = new PdfPTable(2); // create a table with 2 columns
// Why did you create a table with width 527?
// You are already divising your page in 3 columns.
// Why would you try to stuff a table that spans the complete width
// of a page in a column that is only 1/3 of a page???
table.setWidthPercent(100);
// Also: you were setting the colspan of a cell to 8
// in a table with only two columns. Why???
table.addHeaderCell("Fruits");
table.addHeaderCell("Price");
while (rs.next()) {
    table.addCell(rs.getString("fruits"));
    table.addCell(rs.getString("price"));
}
document.add(table);