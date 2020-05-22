final Function<String,Integer> a = (name)->name.length();
Predicate<String> pred = distinctByKey(a);
System.out.println(pred.test("JOHN"));
System.out.println(pred.test("STEPHEN"));
System.out.println(pred.test("ORTIZ"));
System.out.println(pred.test("RONDON"));