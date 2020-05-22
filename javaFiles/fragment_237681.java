public class Office {
    private int sleepTime;
    private int revenue;

    public Office(int sleepTime, int revenue) {
        this.sleepTime = sleepTime;
        this.revenue = revenue;
    }

    public int getRevenue() {
        return revenue;
    }

    public Single<Integer> compute() {
        return Single.timer(sleepTime, TimeUnit.MILLISECONDS).map(l -> this.revenue);
    }
}


public class Tester {
    private static int[] DELAYS = {475, 500, 375, 100, 250, 125, 150, 225, 200, 425, 275, 350, 450, 325, 400, 300, 175};

    public static void main(String[] args) {
        final ArrayList<Office> offices = new ArrayList<>();

        for (int i = 0; i < 1_000_000; i++) {
            offices.add(new Office(DELAYS[i % DELAYS.length], 1));
        }
        int totest = offices.stream().mapToInt(Office::getRevenue).sum();

        final Instant start = Instant.now();
        final Flowable<Office> officeObservable = Flowable.fromIterable(offices);
        int computation = officeObservable.flatMapSingle(Office::compute).reduce(Integer::sum).blockingGet();
        boolean verdict = computation == totest;
        System.out.println("" + computation + " " + (verdict ? "ok" : "nok"));
        final Instant end = Instant.now();

        System.out.printf("Ends in %dms%n", Duration.between(start, end).toMillis());
    }
}