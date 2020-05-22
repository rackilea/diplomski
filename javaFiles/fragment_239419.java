public static void main( String[] args ) {

 Scanner keyboard = new Scanner(System.in);

 System.out.println( "Type in a message" );
 System.out.print( "Message: " );
 String message = keyboard.nextLine();

  int n = 10;
  while ( n < 100 ) {
    System.out.println(n + "." +  message);
    n+=10;
  }
 }
}