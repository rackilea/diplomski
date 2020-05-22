Set<String> vmv = new TreeSet<String>();

System.out.println(vmv.add("a")); // prints true
System.out.println(vmv.size());   // prints 1

System.out.println(vmv.add("a")); // prints false
System.out.println(vmv.size());   // prints 1