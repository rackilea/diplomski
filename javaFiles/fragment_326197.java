public static void main( String[] args ){
    System.out.println( "Welcome to Siddharth's number guessing game. \nThink of a number between 1 and 100 and "
            + "press 1 to continue" );

    Scanner x = new Scanner( System.in );

    if( x.nextInt() == 1 ){

        int high = 100;
        int low = 0;
        int guess = ( high + low ) / 2;

        System.out.println( "Is your number " + guess + "? Press 0 if yes, press 1 if your number is higher than " +
                "this number or press 2 if your number is lower than this number!" );


        while( true ){

            int ans = x.nextInt();
            if( ans == 0 ){
                break;

            }else if( ans == 1 ){
                low = guess;

            }else if( ans == 2 ){
                high = guess;

            }

            guess = ( high + low ) / 2;
            System.out.printf( "Is your number %d ? (0: yes, 1: higher, 2:lower) ", guess );
        }

        System.out.println( "The number you thought of is " + guess + "! Thanks for playing!" );

    }else{
        System.out.println( "No problem. Restart the program and press 1 when ready!" );
    }
}