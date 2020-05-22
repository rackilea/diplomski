ArrayList<Row> bigList = new ArrayList<Row>();
//Insert all data
//...
Iterator i = bigList.iterator();
ArrayList<Row> listA = new ArrayList<Row>();
ArrayList<Row> listB = new ArrayList<Row>();
ArrayList<Row> listC = new ArrayList<Row>();
while(i.hasNext()){
  Row now = i.next();
  switch(now.getColumnB()){
    case "AIR SHOPPING":
      listA.add(now);
      break;
    case "AVAILABILITY":
      listB.add(now);
      break;
    case "CONNECTIVITY":
      listC.add(now);
      break;
  }
}
//And at this point you should have your lists