private static int calculateNumberOfWeekendsInRange(Date startDate, Date endDate) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(startDate);

    int counter = 0;
    while(!calendar.getTime().after(endDate)) {
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek==1 || dayOfWeek==7) {
            counter++;
        }
        calendar.add(Calendar.DAY_OF_MONTH, 1);
    }

    return counter;
}