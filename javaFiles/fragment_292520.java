for(int hourInDay = 0; hourInDay < 24; hourInDay++) 
    {   
        for(int minute = 0; minute <= 59; minute++)
        {   
            raf.writeLong(cal.getTimeInMillis());
            cal.add(Calendar.MINUTE, 1);                    
        }
    }