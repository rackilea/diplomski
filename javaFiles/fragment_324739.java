static boolean doOnce = true; //put this somewhere to be executed once , like begin of your program
...
if ( doOnce ) {
        System.out.println("Your total due is: $" + userTotal);
        doOnce = false;
}