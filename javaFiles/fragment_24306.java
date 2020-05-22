private static final ReferenceQueue<Integer> QUEUE = new ReferenceQueue<>();
private static final Set<PhantomReference<Integer>> REGISTERED = new HashSet<>();
public static void main(String[] args)
        throws InterruptedException, IllegalAccessException {
    List<Integer> stronglyReferenced = new ArrayList<>();
    for(int i = 0; i < 10; i++) {
        Integer object = new Integer(i);
        stronglyReferenced.add(object);
        REGISTERED.add(new PhantomReference<>(object, QUEUE));
    }
    gcAndPoll("initial");
    stronglyReferenced.removeIf(i -> i%2 == 0);
    gcAndPoll("after removing even");
    stronglyReferenced.clear();
    gcAndPoll("after remove all");
    if(REGISTERED.isEmpty()) System.out.println("all objects collected");
}
static final Field REFERENT;
static {
    try {
        REFERENT = Reference.class.getDeclaredField("referent");
        REFERENT.setAccessible(true);
    } catch (NoSuchFieldException ex) {
        throw new ExceptionInInitializerError(ex);
    }
}
private static void gcAndPoll(String msg)
        throws InterruptedException, IllegalAccessException {
    System.out.println(msg);
    System.gc();
    Thread.sleep(100);
    for(;;) {
        Reference<?> r = QUEUE.poll();
        if(r == null) break;
        Object o = REFERENT.get(r);
        System.out.println("collected (and now resurrected)"+o);
        REGISTERED.remove(r);
    }
}