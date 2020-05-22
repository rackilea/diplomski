Class<A> clazz = A.class;
Method met = clazz.getDeclaredMethod("method", List.class);
//                    ^^^^^^^^
met.setAccessible(true);
String res = (String) met.invoke(new A(), new ArrayList<Integer>());
//                               ^^^^^^^
System.out.println(res);