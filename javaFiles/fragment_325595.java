Scanner sc = new Scanner(System.in);
while(sc.hasNext()) {
  String next = sc.next();
  if("q".equals(next)) break;

  float value = new Float(next);
  System.out.println("Float: "+value);
}