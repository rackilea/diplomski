for (Entry<String, List<MyObject>> entry : subTotalsByName.entrySet()) {

  int subtotal = 0;

  List<MyObject> myObjects = entry.getValue();
  for (MyObject myObj : myObjects){
    System.out.println(myObj.name + " " + myObj.price);
    subtotal += myObj.price;
  }

  System.out.println("subTotal for " + entry.getKey() + " is " + subtotal);
  System.out.println();
}