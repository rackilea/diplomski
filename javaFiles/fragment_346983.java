ArrayList<Integer> myInts = new ArrayList<Integer>();
myInts.add(1);
myInts.add(2);
myInts.add(3);
myInts.add(4);
int i = myInts.get(r.nextInt(myInts.size())); // 1,2,3,4
myInts.remove(3);
int j = myInts.get(r.nextInt(myInts.size())); // 1,2,4