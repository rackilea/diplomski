Random r = new Random(1);

Field f;
try {
    f = r.getClass().getDeclaredField("seed");
    f.setAccessible(true);
    AtomicLong seed = (AtomicLong) f.get(r);
    System.out.println("seed: " + seed);

    f = r.getClass().getDeclaredField("mask");
    f.setAccessible(true);
    Long mask = (Long) f.get(r);
    System.out.println("mask: " + mask);

    f = r.getClass().getDeclaredField("multiplier");
    f.setAccessible(true);
    Long multiplier = (Long) f.get(r);
    System.out.println("multiplier: " + multiplier);


    long initialSeed = (seed.longValue() ^ multiplier);
    System.out.println("restored initial seed: " + initialSeed);
} catch (NoSuchFieldException e1) {
} catch (SecurityException e2) {
} catch (IllegalAccessException e3) {
} catch (IllegalArgumentException e4) {
}