Date date = format1.parse(newstr);
Calendar calendar = new GregorianCalendar();
calendar.setTime(date);
while (someCondition(calendar)) {
    doSomethingWithTheCalendar(calendar);
    calendar.add(Calendar.DATE, 1);
}