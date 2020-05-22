class YourClass {
    private Set<DayOfWeek> activeDays;

    public void addActiveDay(DayOfWeek day){
        activeDays.add(day);
    }
}
...

yourclass.addActiveDay(DayOfWeek.Friday);