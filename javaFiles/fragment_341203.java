byte b = -1; // 0xFF
char ch = (char) b; // 0xFFFF
int i = ch;
System.out.println(i); // prints "65535", which is 0xFFFF

byte b = -1; // 0xFF
char ch = (char) (b & 0xFF); // 0xFF
int i = ch;
System.out.println(i); // prints "255", which is 0xFF