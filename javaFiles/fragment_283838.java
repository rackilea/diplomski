public class Numbers {    
    private final static int numberOfEntries = 20_000_000;
    private final static int maxRandom = numberOfEntries;

    private Set<Integer> s1;
    private Set<Integer> s2;

    @Before
    public void setUp() throws Exception {
        Random random = new Random(42);
        s1 = fillWithRandomEntries(random, numberOfEntries);
        s2 = fillWithRandomEntries(random, numberOfEntries);
    }

    private static Set<Integer> fillWithRandomEntries(Random random, int entries) {
        Set<Integer> rv = new HashSet<>();
        for (int i = 0; i < entries; i++) {
            rv.add(random.nextInt(maxRandom));
        }
        return rv;
    }

    @Test
    public void classic() {
        long start = System.currentTimeMillis();
        HashSet<Integer> intersection = new HashSet<>();
          s1.forEach((i) -> {
           if (s2.contains(i))
             intersection.add(i);
        });
        long end = System.currentTimeMillis();
        System.out.println("foreach duration: " + (end-start) + " ms");
        System.out.println("intersection.size() = " + intersection.size());
    }


    @Test
    public void retainAll() {
        long start = System.currentTimeMillis();
        s1.retainAll(s2);
        long end = System.currentTimeMillis();
        System.out.println("Retain all duration: " + (end-start) + " ms");
        System.out.println("intersection.size() = " + s1.size());
    }

    @Test
    public void streams() {
        long start = System.currentTimeMillis();
        Set<Integer> intersection = s1.stream().filter(i -> s2.contains(i)).collect(Collectors.toSet());
        long end = System.currentTimeMillis();
        System.out.println("streaming: " + (end-start) + " ms");
        System.out.println("intersection.size() = " + intersection.size());
    }

    @Test
    public void parallelStreams() {
        long start = System.currentTimeMillis();
        Set<Integer> intersection = s1.parallelStream().filter(i -> s2.contains(i)).collect(Collectors.toSet());
        long end = System.currentTimeMillis();
        System.out.println("parallel streaming: " + (end-start) + " ms");
        System.out.println("intersection.size() = " + intersection.size());
    }
}