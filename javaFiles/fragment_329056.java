PriorityQueue<VEvent> plan = new PriorityQueue<VEvent>(10, new Comparator<VEvent>() {    
    @Override
    public int compare(VEvent e1, VEvent e2)
    {
        Date d1 = e1.getStartDate().getDate();
        Date d2 = e2.getStartDate().getDate();
        return d1.compareTo(d2);
    }
});