Scanner recIn = new Scanner(record); 
recIn.useDelimiter("\\s*\\|\\s*");
if (recIn.hasNext()) {
  tableRow[0] = recIn.next(); 
  tableRow[1] = recIn.next(); 
  tableRow[2] = recIn.next(); 
  tableRow[3] = recIn.next(); 
  tableRow[4] = recIn.next();
}