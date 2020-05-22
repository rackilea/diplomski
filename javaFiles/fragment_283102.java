@Override
    public String toString() {
    //DayOfWeek is just an enum of days (strings)
        return holidayName + " falls on "
                    + DayOfWeek.values()[calendar.get(Calendar.DAY_OF_WEEK)]; // Now you won't get the same day every time. :)
    }