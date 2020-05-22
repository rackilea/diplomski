Calendar tmp = (Calendar) day1.clone();
    ArrayList<Calendar> fullDates = new ArrayList<Calendar>();
    while (tmp.before(day2)) {
        fullDates.add((Calendar) tmp.clone());
        tmp.add(Calendar.DAY_OF_MONTH, 1);
    }
    return fullDates;