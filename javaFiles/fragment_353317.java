switch ( x ) {
    case 0 :
        Collections.sort( p.members, new compareThings.CEmpathy());
        break; // IMPORTANT
   case 1 :
       Collections.sort( p.members, new compareThings.CFear());
       break; // IMPORTANT
   case 2 :
       Collections.sort( p.members, new compareThings.CCarry());
       break; // can be omitted here
}