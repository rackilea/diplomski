ArrayList<String> dateSelections = new ArrayList<>();
while (beginCalendar.before(finishCalendar)) 
{
        String date = formater.format(beginCalendar.getTime()).toUpperCase();
        dateSelections.add(date);
        beginCalendar.add(Calendar.MONTH, 1);
}