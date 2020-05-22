StringBuilder message = new StringBuilder();

switch ( dow ) {
    case DayOfWeek.MONDAY:
    case DayOfWeek.TUESDAY: 
    case DayOfWeek.WEDNESDAY: 
    case DayOfWeek.THURSDAY:  
    case DayOfWeek.FRIDAY: 
        message.append( "Weekday - Working for a living. " );
        break;

    case DayOfWeek.SATURDAY:
    case DayOfWeek.SUNDAY: 
        message.append( "Wohoo! Weekend… Party on Garth! " );
        break;

    default: 
        System.out.println("ERROR - Unexpectedly reached case DEFAULT on value for DayOfWeek 'dow'.");
    }