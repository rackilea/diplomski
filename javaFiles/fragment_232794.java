public ArrayList<String> getDaysBetween(String start, String end){
    DateTimeFormatter formatter = DateTimeFormat.forPattern("dd-MM-yyyy");
    DateTime dstart = formatter.parseDateTime(start);
    DateTime dend = formatter.parseDateTime(end);

    ArrayList<String> days = new ArrayList<>();
    while (dstart.getDayOfYear() <= dend.getDayOfYear()){
        String day = dstart.dayOfWeek().getAsText();
        if(!days.contains(day)){
            days.add(day);
        }
        dstart = dstart.plusDays(1);
    }
    return days;
}