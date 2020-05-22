public static void main(String[] args){
  Scanner sc = new Scanner(System.in);
  int input;
  do {
    System.out.println("Enter size(must be odd): ");
    input = sc.nextInt();
  } while(input%2 == 0);

  int half = input/2 + 1;
  for( int iRow = 1; iRow <= input; ++iRow ){
    for( int iCol = 1; iCol <= input; ++iCol ){
      // Highest precedence: middle row, middle column
      if( iRow == half || iCol == half ){
        System.out.print( 'X' );
      } else
      // next, the diagonals
      if( iRow == iCol || input - iCol + 1 == iRow ){
        System.out.print( '0' );
      } else {
        // the rest is white space
        System.out.print( ' ' );
      }
    }
    System.out.println();
  }
}