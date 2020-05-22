String input = "Boo;Foo;1000";
Integer someInt = new Integer(0);

String[] split = input.split(";", -1);
Object[] arr = new Object[split.length];
System.arraycopy(split, 0, arr, 0, split.length);