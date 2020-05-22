// get IdentytitySet wich wrap IdentityHashMap
Set<Person> set = Collections.newSetFromMap( new IdentityHashMap<>() ) 
//test 
Person p  = new Person("a",1);
Person p2 = new Person("a",1);
set.add(p);
set.add(p2);
p.setD(999999999);
set.add(p);//add Person with changed "d" to 999999999
System.out.println(set.toString());