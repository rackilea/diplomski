Boolean boolean1 = new Boolean("true");
Boolean boolean2 = new Boolean("true");
Boolean boolean3 = new Boolean("true");

System.out.println(System.identityHashCode(boolean1));
System.out.println(System.identityHashCode(boolean2));
System.out.println(System.identityHashCode(boolean3));

Boolean valueOf1 = Boolean.valueOf("true");
Boolean valueOf2 = Boolean.valueOf("true");

System.out.println(System.identityHashCode(valueOf1));
System.out.println(System.identityHashCode(valueOf2));