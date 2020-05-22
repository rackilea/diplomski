list1 // your 1st list
list2 // your second list

Set<Type> s1 = new HashSet<Type>();
s1.addAll(list1); // add your values from list 1
Set<Type> s2 = new HashSet<Type>(); 
s2.addAll(list2); // add your values from list 2

Set<Type> intersection = new HashSet<Type>(s1);
intersection.retainAll(s2);
System.out.println(intersection.size());