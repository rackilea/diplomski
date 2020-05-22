Calendar clone = nowCalendar.clone();

while (!clone.after(futureCalendar)) {
    validDays.add(clone.getTime());
    clone.add(Calendar.DATE, 1);
}