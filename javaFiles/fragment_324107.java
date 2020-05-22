public int getDayRange() {

        //startDate = "Sat Nov 06 00:00:00 EDT 2010";
        //endDate = "Sun Nov 07 23:59:59 EST 2010";

    TimeZone tz1 = TimeZone.getTimeZone("EDT");
    TimeZone tz2 = TimeZone.getTimeZone("EST");

    GregorianCalendar cal1 = new GregorianCalendar(tz1); 
    GregorianCalendar cal2 = new GregorianCalendar(tz2); 

    cal1.setTime(startDate);
    cal2.setTime(endDate);

    if (cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)) {
        return cal2.get(Calendar.DAY_OF_YEAR) - cal1.get(Calendar.DAY_OF_YEAR) + 1;
    } else {
        //this gets complicated, but you can see what to do, plenty of examples online
    }

  }