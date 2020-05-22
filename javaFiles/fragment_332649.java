public static void findEvents(Map<Date, Event> dateEvents, Date targetDate) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    String target = dateFormat.format(targetDate); 
    for (Map.Entry<Date, Event> entry : dateEvents.entrySet()) {
        if (dateFormat.format(entry.getKey()).equals(target)) {
            System.out.println("Event " + entry.getValue() + " is on the specified date");
        }
    }
}