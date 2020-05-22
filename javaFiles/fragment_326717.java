Iterator<MyObject> myObjects = csv.parse(strat, getReader("file.txt")).iterator();

while (myObjects.hasNext()) {
    MyObject myObject = myObjects.next();
    System.out.println(myObject);
}