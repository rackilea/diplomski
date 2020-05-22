private class Events {
    Map<Date, List<String>> events = new HashMap<Date, List<String>>();
    public List<String> getEvents(int month, int day) {
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.set(0, month, date, 0, 0, 0);
        Date date = calendar.getTime();
        List<String> list = events.get(date);
        if (list == null) {
            list = new ArrayList<String>();
            events.put(date, list);
        }
        return list;
    }
}