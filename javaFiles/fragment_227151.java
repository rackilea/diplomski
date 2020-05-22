public class ResourceManager {
    static final ReferenceQueue<Resource> QUEUE = new ReferenceQueue<>();
    static final List<ActualResource> FREE = new ArrayList<>();
    static final Map<WeakReference<?>,ActualResource> USED = new HashMap<>();
    static int NEXT_ID;

    public static synchronized Resource getResource() {
        for(;;) {
            Reference<?> t = QUEUE.poll();
            if(t==null) break;
            ActualResource r = USED.remove(t);
            if(r!=null) FREE.add(r);
        }
        ActualResource r;
        if(FREE.isEmpty()) {
            System.out.println("allocating new resource");
            r = new ActualResource(NEXT_ID++);
        }
        else {
            System.out.println("reusing resource");
            r = FREE.remove(FREE.size()-1);
        }
        Resource frontEnd = new Resource(r);
        USED.put(new WeakReference<>(frontEnd, QUEUE), r);
        return frontEnd;
    }
    /**
     * Allow the underlying actual resource to get garbage collected with r.
     */
    public static synchronized void stopReusing(Resource r) {
        USED.values().remove(r.actual);
    }
    public static synchronized void clearCache() {
        FREE.clear();
        USED.clear();
    }
}