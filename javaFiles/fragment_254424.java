Scanner s = new Scanner("just\ndo   ,   it$bro,tm");
s.useDelimiter("(,|\\s|\\$)+");
System.out.println(s.next());
System.out.println(s.next());
System.out.println(s.next());
System.out.println(s.next());
System.out.println(s.next());