switch ( whatever ) {
    case thisThing: 
        message.append( "Use vanilla." );
        break;

    case thatThing: 
        message.append( "Use chocolate." );
        break;

    case theOtherThing: 
        message.append( "Use almond." );
        break;

    default: 
        System.out.println("ERROR - Unexpectedly reached case DEFAULT on value for whatever.");
    }