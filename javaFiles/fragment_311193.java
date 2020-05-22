public String getPreviousThursday() {
    String csDate = "";
    int perSut = 0;
    Calendar calendar = Calendar.getInstance();
    int day = calendar.get(Calendar.DAY_OF_WEEK);

    switch (day) {
    case Calendar.SUNDAY:
        perSut = -3;
        break;
    case Calendar.MONDAY:
        perSut = -4;
        break;
    case Calendar.TUESDAY:
        perSut = -5;
        break;
    case Calendar.WEDNESDAY:
        perSut = -6;
        break;
    case Calendar.THURSDAY:
        perSut = 0;
        break;
    case Calendar.FRIDAY:
        perSut = -1;
        break;
    case Calendar.SATURDAY:
        perSut = -2;
        break;
    }

    SimpleDateFormat mDF = new SimpleDateFormat("dd-MM-yyyy");
    calendar.add(Calendar.DAY_OF_MONTH, perSut);
    csDate = mDF.format(calendar.getTime());

    System.out.println("Prev Thursday >> " + csDate);

    return csDate;
}

public String getNextThursday() {
    String csDate = "";
    int perSut = 0;
    Calendar calendar = Calendar.getInstance();
    int day = calendar.get(Calendar.DAY_OF_WEEK);

    switch (day) {
    case Calendar.SUNDAY:
        perSut = 4;
        break;
    case Calendar.MONDAY:
        perSut = 3;
        break;
    case Calendar.TUESDAY:
        perSut = 2;
        break;
    case Calendar.WEDNESDAY:
        perSut = 1;
        break;
    case Calendar.THURSDAY:
        perSut = 7;
        break;
    case Calendar.FRIDAY:
        perSut = 6;
        break;
    case Calendar.SATURDAY:
        perSut = 5;
        break;
    }

    SimpleDateFormat mDF = new SimpleDateFormat("dd-MM-yyyy");
    calendar.add(Calendar.DAY_OF_MONTH, perSut);
    csDate = mDF.format(calendar.getTime());

    System.out.println("NextThursday >> " + csDate);

    return csDate;
}