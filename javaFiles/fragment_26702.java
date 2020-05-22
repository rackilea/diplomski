Class<?> clazz = Child.class;
Object cc = clazz.newInstance();

Field f1 = cc.getClass().getSuperclass().getDeclaredField("a_field");
f1.setAccessible(true);
f1.set(cc, "reflecting on life");
String str1 = (String) f1.get(cc);
System.out.println("field: " + str1);