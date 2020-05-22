byte b1 = (byte) 129;
String s1 = String.format("%8s", Integer.toBinaryString(b1 & 0xFF)).replace(' ', '0');
System.out.println(s1); // 10000001

byte b2 = (byte) 2;
String s2 = String.format("%8s", Integer.toBinaryString(b2 & 0xFF)).replace(' ', '0');
System.out.println(s2); // 00000010