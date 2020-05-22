if ( year % 400 == 0 )
    {
        if ( year % 4 == 0 && year % 100 != 0 )
            dayNumber = 31 + 29 + day;
    }
    else
        dayNumber = 31 + 28 + day;