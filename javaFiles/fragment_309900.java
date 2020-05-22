String header = "Col" + (table.getColumnCount() + 1);
model.addColumn( header );

//  AutoCreate is turned off so create table column here

TableColumn column = new TableColumn( table.getColumnCount() );
column.setHeaderValue( header );
table.addColumn( column );