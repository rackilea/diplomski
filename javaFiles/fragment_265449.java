public static void main(String[] args) {
  A a=new A();

  Scanner in= new Scanner(System.in);
  String x=in.next(); 
  if(x.equals("a")){  // the input is "a";
    String y= a.a;
    System.out.println(y);
  }
  else if(x.equals("b")){ // the input is "b";
    String y= a.b;
    System.out.println(y);
  }
  else System.out.println("Input a or b please !!!");
}