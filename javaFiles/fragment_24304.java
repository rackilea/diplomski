private static final ReferenceQueue<Integer> QUEUE = new ReferenceQueue<>();
static class IntegerPhantomReference extends PhantomReference<Integer> {
    final int value;
    public IntegerPhantomReference(Integer ref) {
        super(ref, QUEUE);
        value = ref.intValue();
    }
    public String toString() {
        return "Integer[value="+value+"]";
    }
}
private static final Set<IntegerPhantomReference> REGISTERED = new HashSet<>();
public static void main(String[] args) throws InterruptedException {
    List<Integer> stronglyReferenced = new ArrayList<>();
    for(int i = 0; i < 10; i++) {
        Integer object = new Integer(i);
        stronglyReferenced.add(object);
        REGISTERED.add(new IntegerPhantomReference(object));
    }
    gcAndPoll("initial");
    stronglyReferenced.removeIf(i -> i%2 == 0);
    gcAndPoll("after removing even");
    stronglyReferenced.clear();
    gcAndPoll("after remove all");
    if(REGISTERED.isEmpty()) System.out.println("all objects collected");
}
private static void gcAndPoll(String msg) throws InterruptedException {
    System.out.println(msg);
    System.gc(); Thread.sleep(100);
    for(;;) {
        Reference<?> r = QUEUE.poll();
        if(r == null) break;
        System.out.println("collected "+r);
        REGISTERED.remove(r);
    }
}