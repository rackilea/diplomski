class Counters {
    int counter1; // use meaningful names here
    final counter2;
    public Counters(counter1, counter2) { this.counter1 = counter1; this.counter2 = counter2; }
}

Map<String, Counters> common = new HashMap<>();

Counters counters = common.get(code);
if (counters == null)
    common.put(code, counters = new Counters(1, count));
else
    counters.counter2++;