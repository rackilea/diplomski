Font font = FontFactory.getFont(FontFactory.HELVETICA, 6)
PdfPTable table = new PdfPTable(1);
PdfPCell cell = new PdfPCell();
List fruitList = new List(List.UNORDERED);
fruitList.add(new ListItem("Mango", font));
fruitList.add(new ListItem("Apple", font));
fruitList.add(new ListItem("Orange", font));
cell.addElement(fruitList);
table.addCell(cell);