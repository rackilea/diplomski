public static void main( String[] args ) {

 Scanner keyboard = new Scanner(System.in);

 System.out.println( "Type in a message" );
 System.out.print( "Message: " );
 String message = keyboard.nextLine();

  int n = 0;
  while ( n < 10 ) {
    System.out.println( (n+1) + "0." +  message );
    n++;
  }
 }
}