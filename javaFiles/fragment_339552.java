List<String> list1 = new ArrayList();
list1.add("b");   // list1
list1.add("c");   // list1

doStuff(list1);


public void doStuff(List<String> list1){
       // should print 2
       System.out.println(list1.size());  // list1

}