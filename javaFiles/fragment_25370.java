long m1() {
hashSet.add("hai");
hashSet.add("me");
hashSet.add("you ");
hashSet.add("I");
hashSet.add("Us");
Iterator it = hashSet.iterator();
long startTime = System.nanoTime();

while (it.hasNext()) {
    System.out.println(it.next());
}
long endTime = System.nanoTime();
System.out.println("time taken in nano seconds" + endTime-startTime); 
return endTime-startTime;
}