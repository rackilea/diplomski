Vector<Vector<String>> data=new Vector<>();
//Fill this Vector above with the initial data

Vector<String> columns=new Vector<String>();
//Fill this with column names

DefaultTableModel tableModel=new DefaultTableModel(data, columns);
JTable table=new JTable(tableModel);
//Display the table as you like

... //Query the database and get the ResultSet (let's call it rs)

while(rs.next){

  Vector<String> newRow=new Vector<>();

  //Get the data from the resultset and fill this new row

  tableModel.addRow(newRow);

}//while closing