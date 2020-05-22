public static String calcDay(String currentDay, int incrementDays) {

    ArrayList<String> days = new ArrayList<String>();

    days.add(0,"mon");
    days.add(1,"tue");
    days.add(2,"wed");
    days.add(3,"thu");
    days.add(4,"fri");
    days.add(5,"sat");
    days.add(6,"sun");

    int currentIndex = days.indexOf(currentDay.toLowerCase());
    int newDayIndex = (currentIndex + incrementDays) % 7;
    return days.get(newDayIndex);
}