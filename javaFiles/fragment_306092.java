String[] a=new String[] {"alpha","beta"};
String[] b=new String[] {"alpha","beta","gamma","xxxx","yyyy"};
HashSet<String> set1 = new HashSet<String>(Arrays.asList(a));
HashSet<String> set2 = new HashSet<String>(Arrays.asList(b));
set1.retainAll(set2);
System.out.println(set1);     //Output : [alpha, beta]