String str = "This is String , split by StringTokenizer, created by mkyong";
System.out.println("---- Split by comma ',' ------");
StringTokenizer st2 = new StringTokenizer(str, ",");

while (st2.hasMoreElements()) {
  System.out.println(st2.nextElement());
}