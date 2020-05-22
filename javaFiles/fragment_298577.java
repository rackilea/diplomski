public static int calcDaysDiff(Date day1, Date day2) {
    Date d1 = new Date(day1.getTime());
    Date d2 = new Date(day2.getTime());
    Calendar date1 = Calendar.getInstance();
    date1.setTime(d1);
    Calendar date2 = Calendar.getInstance();
    date2.setTime(d2);
    //checks if the start date is later then the end date - gives 0 if it is
    if (date1.get(Calendar.YEAR) >= date2.get(Calendar.YEAR)) {
        if (date1.get(Calendar.DAY_OF_YEAR) >= date2.get(Calendar.DAY_OF_YEAR)) {
            return 0;
        }
    }
    //checks if there is a daylight saving change between the two dates

    int offset = calcOffset(d1, d2);

    if (date1.get(Calendar.YEAR) > date2.get(Calendar.YEAR)) {
        //swap them
        Calendar temp = date1;
        date1 = date2;
        date2 = temp;
    }

    return calcDaysDiffAux(date1, date2) + checkFullDay(date1, date2, offset);
}

// check if there is a 24 hour diff between the 2 dates including the daylight saving offset
public static int checkFullDay(Calendar day1, Calendar day2, int offset) {
    if (day1.get(Calendar.HOUR_OF_DAY) <= day2.get(Calendar.HOUR_OF_DAY) + offset) {
        return 0;
    }
    return -1;
}

// find the number of days between the 2 dates. check only the dates and not the hours
public static int calcDaysDiffAux(final Calendar day1, final Calendar day2) {
    Calendar dayOne = (Calendar) day1.clone(),
            dayTwo = (Calendar) day2.clone();

    if (dayOne.get(Calendar.YEAR) == dayTwo.get(Calendar.YEAR)) {
        return Math.abs(dayOne.get(Calendar.DAY_OF_YEAR) - dayTwo.get(Calendar.DAY_OF_YEAR));
    } else {

        int extraDays = 0;

        while (dayTwo.get(Calendar.YEAR) > dayOne.get(Calendar.YEAR)) {
            dayTwo.add(Calendar.YEAR, -1);
            // getActualMaximum() important for leap years
            extraDays += dayTwo.getActualMaximum(Calendar.DAY_OF_YEAR);
        }

        return extraDays - day1.get(Calendar.DAY_OF_YEAR) + day2.get(Calendar.DAY_OF_YEAR);
    }
}