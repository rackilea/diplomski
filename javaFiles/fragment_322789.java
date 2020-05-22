DateFormat df = new SimpleDateFormat("yyyy-dd-MM"); 
    Date startDateObject;
    Date endDateObject;
    try {
        startDateObject = df.parse(newStartDate);
        endDateObject=df.parse(newEndDate);

    } catch (ParseException e) {
        e.printStackTrace();
    }