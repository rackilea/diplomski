int     i1 = 1000;
Integer i2 = 1000;
Integer i3 = new Integer(1000);

System.out.println(Integer.valueOf(i1).hashCode());
System.out.println(i2.hashCode());
System.out.println(i3.hashCode());