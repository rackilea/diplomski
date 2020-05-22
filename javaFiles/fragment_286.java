List<Integer> myInts = new ArrayList<Integer>();
myInts.add(1);
myInts.add(2);

List<Number> myNums = myInts; //compiler error
myNums.add(3.14); //heap polution