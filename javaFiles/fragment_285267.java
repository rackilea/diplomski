public static void main(String args[]) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
    System.out.println("System time before: " + System.currentTimeMillis());
    Random r1 = new Random();
    Random r2 = new Random(System.currentTimeMillis());
    System.out.println("System time after: " + System.currentTimeMillis());

    Field seed = Random.class.getDeclaredField("seed");
    seed.setAccessible(true);
    AtomicLong seed1 = (AtomicLong) seed.get(r1);
    AtomicLong seed2 = (AtomicLong) seed.get(r2);

    System.out.println("seed1 = " + seed1);
    System.out.println("seed2 = " + seed2);
}