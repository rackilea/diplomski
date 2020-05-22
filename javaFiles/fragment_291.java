List<Object> myObjs = new List<Object();
myObjs.add("Luke");
myObjs.add("Obi-wan");

List<? super Number> myNums = myObjs;
myNums.add(10);
myNums.add(3.14);