String s = "SomeTestString!";
if(s.length() < 128) {
   s = String.format("%-128s", s ).replace(' ', '0');
} else {
   s = s.substring(0,128);
}
System.out.println(s);