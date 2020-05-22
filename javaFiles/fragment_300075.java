for ( int x = 0; x <= num2; x++ ) {
  int y = 100 - x;

  System.out.println(y + " bottles of beer on the wall " + y + " bottles of beer");
  System.out.println("Take one down, pass it around, " + (y - 1) + " bottles of beer on the wall.\n");
}