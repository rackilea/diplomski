data=new Object[numberOfRows][numberOfColumns];
for(int i=0;i<numberOfRows;i++) {
  if (!rs.next())
    throw new IllegalStateException();
  int j=0;
  // int colType=rsmd.getColumnType(j+1); 
  // System.out.println(colType);
  data[i][j]=rs.getInt("course_id");
  System.out.print("0th: "+data[i][j++]+"    ");
  data[i][j]=rs.getString("course_name");
  System.out.print("1st:"+data[i][j++]+"    ");
  data[i][j]=rs.getString("course_date");
  System.out.print("2nd:"+data[i][j++]+"    ");
  data[i][j]=rs.getString("course_number");
  System.out.print("3rd: "+data[i][j++]+"    ");
  while(j<numberOfColumns) {
    data[i][j]=rs.getString(j + 1);
    System.out.print(j+"th: "+data[i][j++]+"    ");
  }
  System.out.println();
  System.out.println("Done line:"+i);
}