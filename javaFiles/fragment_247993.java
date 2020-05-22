List<MyClass> list = new ArrayList<>();
 //add data to the list

 //print it before sort
 System.out.println(list); 
 Collections.sort(list,MyClass.MY_COMPARATOR);
 //print it after sorting
 System.out.println(list);