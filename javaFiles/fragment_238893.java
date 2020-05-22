public static Comparator<String> randomOrder() {
    ThreadLocalRandom r = ThreadLocalRandom.current();
    int x = r.nextInt(), y = r.nextInt();
    boolean b = r.nextBoolean();
    return Comparator.comparingInt((String s)->s.hashCode()^x)
     .thenComparingInt(s->s.length()^y)
     .thenComparing(b? Comparator.naturalOrder(): Comparator.reverseOrder());
}