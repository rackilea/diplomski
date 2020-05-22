if (query.getCount() > 0 && query.moveToFirst())
    {
        int hours = 0;
        int minutes = query.getInt( "startTimeOfDayMins" );

        Calendar calendar = Calendar.getInstance();
        calendar.set( Calendar.HOUR, hours );
        calendar.set( Calendar.MINUTE, minutes );
        this.startTime = calendar.getTime();

        this.daysOfWeek = ( query.getString( "daysOfWeek" ) ).toLowerCase();

        calendar.set( Calendar.MINUTE, minutes + query.getInt( "durationMins" ) );
        this.endTime = calendar.getTime();

        this.context = null;
    }