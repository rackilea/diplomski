public static void graph (int[] arr) {

          for ( int i=0; i <= 50; i+=5){
              System.out.print(i+" - " + ( i + 4 ) + " :" );
              for ( int num : arr) {
                  if ( num >= i && num <= i + 4)
                      System.out.print("*");

                  }
                  System.out.println();
              }
}