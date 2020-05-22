data = new String[numberOfRow][6];
while (rs.next()) {
  for(int i=0; i<=5; i++){
      data[rs.getRow()][i]=rs.getString(i+1);
  }
}