for(int i=1;i<=columnNum;i++){
    System.out.print(meta.getColumnName(i)+" ");
}

//Get the data
while(rs.next){
  for(int i=1;i<=columnNum;i++){
    System.out.print(rs.getString(i)+" ");
  }
}