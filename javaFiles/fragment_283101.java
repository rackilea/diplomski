@Override
    public String toString() {
    //DayOfWeek is just an enum of days (strings)
        return holidayName + " falls on "
                                        // Here you are using the constant Calendar.DAY_OF_WEEK
                    + DayOfWeek.values()[Calendar.DAY_OF_WEEK - 1]; // Here i get the same day each time
    }