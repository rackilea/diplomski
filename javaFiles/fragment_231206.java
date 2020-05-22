public static void main( String[] args){

  Scanner in = new Scanner(System.in);
  Random r = new Random();
  while(in.hasNext()){
    String str = in.next();
    System.out.println(scrambler(str,r));
  }