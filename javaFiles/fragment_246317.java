String entrance = "text01";
Test t = new Test();

Field f = t.getClass().getDeclaredField(entrance);
System.out.println("value = "+f.getInt(t));

// you can even change the value:
t.text01 = 2013;
System.out.println("value = "+f.getInt(t));