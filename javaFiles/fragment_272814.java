int attackPos = scn.nextInt();

char outcome = map.charAt(attackPos);
switch(outcome){
    case '.':  System.out.println("Miss");
               //use substring to mark this spot as "X"
               break;
    case 's':  System.out.println("Sunk!");   //ship 's' only takes 1 space
               //use substring to mark this spot as "X"
               break;
    case 'c':  System.out.println("Hit!");    //ship 'c' takes 2 spaces
               //use substring to mark this spot as "X"
               break;
    case 'x':  System.out.println("Already Hit");
               break;
}