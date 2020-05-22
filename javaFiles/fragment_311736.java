public class IndexBean {
    public IntexBean() {
    }
    @PostConstruct
    public void init() {
        // Set attributes to a value whichs should work (as you can see one line below)
        currentLunch = new Lunch("Tobi", "Starbucks", new DateTime(2014, 5, 30, 12, 0, 0 ,0));
        // This works without any problems.
        lunches = new ArrayList<Lunch>();
        lunches.add(new Lunch("Tobi", "Starbucks", new DateTime(2014, 5, 30, 12, 0, 0 ,0)));
    }
    //rest of code...
}