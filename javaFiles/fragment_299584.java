Class aClass = Class.forName("package1.A");
Constructor<?> con = aClass.getDeclaredConstructor();
con.setAccessible(true);
Object instance = con.newInstance();
Field intField = aClass.getDeclaredField("i");
intField.setAccessible(true);
Integer i = (Integer)intField.get(instance);