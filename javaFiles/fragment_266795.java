//--

    @Schedules ({
        @Schedule(hour="*/1"),
        @Schedule(hour="*/3"),
        @Schedule(hour="*/6")
    })
    public void timeOutHandler(){

        if(currentHr % 1 == 0)  //-- Check for hourly timeout
            a();
        else if(currentHr % 3 == 0) //-- Similarly
            b();
        else if(currentHr % 6 == 0) //-- Similarly
            c();
    }

//--