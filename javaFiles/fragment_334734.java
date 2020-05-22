if( choice == 1 ){
    if (heads > tails)
         System.out.println("\nYou Won");
    else if(tails > heads )
         System.out.print("\nYou Lost");
}else{

    if ( heads < tails ) 
        System.out.println("\nYou Won");
    else if( tails < heads )
        System.out.print("\nYou Lost");
}
if( heads == tails )
    System.out.println(\n"It is a tie!");