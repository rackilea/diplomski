List<String> list1=new ArrayList<String>();
list1.add("a");
list1.add("b");
// c is missing in the list
list1.add("d");
list1.add("e");
ListIterator<String> it=list1.listIterator();
while(it.hasNext()){
    if(it.next().equals("b")){
        // add c in the list after b
        it.add("c");
    }
}
System.out.println(Arrays.toString(list1.toArray(new String[]{})));