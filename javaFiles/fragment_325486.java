Iterator<String> iterator = mylist.iterator();
while (iterator.hasNext()) {
    System.out.println(output);
    mylist = new ArrayList<String>(); //It worked 
    mylist.add(output);
}