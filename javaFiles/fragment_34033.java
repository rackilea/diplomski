String o1 = "\u00F6";
String o2 = "o\u0308";
System.out.println(o1 + " equals to " + o2 + " is " + o1.equals(o2));
System.out.println(o1 + " compareTo " + o2 + " is " + o1.compareTo(o2));
System.out.println(o1 + " is " + Arrays.toString(o1.toCharArray()));
System.out.println(o2 + " is " + Arrays.toString(o2.toCharArray()));