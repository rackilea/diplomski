Calendar beginCalendar = Calendar.getInstance();
beginCalendar.setTime(myObject.getBeginDate());
Calendar endCalendar = Calendar.getInstance();
beginCalendar.setTime(myObject.getEndDate());


while (beginCalendar.compareTo(endCalendar) <= 0) {
     // ... calculations
    beginCalendar.add(Calendar.DATE, 1);
}