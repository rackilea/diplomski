while ( !name4.equals("stay") )
{
     System.out.print( "Would you like to hit or stay? " );
     String name4 = keyboard.next();

     total2 = total+number4;
     number4 = random.nextInt(9)+2;

     System.out.println( "You drew a " + number4 + ". " );
     System.out.println( "Your total is " + (total + number4) + ". " );

     if ( total == 21 )
     {
             System.out.print( "YOU WIN!" );
     }

}