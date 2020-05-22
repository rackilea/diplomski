String s = "SomeTestString!";
if(s.length() < 128) {
   s = s.replace(s.length(), 128, "0");
} else {
   s = s.substring(0,128) ;
}
System.out.println(s);