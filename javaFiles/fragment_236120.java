public class WorldRendererGL {

    protected Map<Vector2i, RenderedRegion> regions     = new ConcurrentHashMap<>();
    protected Queue<RegionLoader>           running     = new ConcurrentLinkedQueue<>();
    protected Set<RenderedRegion>           todo        = ConcurrentHashMap.newKeySet();

    protected ExecutorService               executor;

    /** Recalculate everything */
    public void invalidateTextures() {
        //Abort current calculations
        running.forEach(f -> f.invalid.set(true));
        running.clear();
        todo.addAll(regions.values());

        for (int i = 0; i < regions.size(); i++) {
            RegionLoader loader = new RegionLoader();
            running.add(loader);
            executor.submit(loader);
        }
    }

    protected class RegionLoader implements Runnable {

        /** Set this to true to nullify all calculations*/
        final AtomicBoolean invalid = new AtomicBoolean(false);

        @Override
        public void run() {
            try {
                if (invalid.get())
                    return;
                RenderedRegion region = null;
                region = nextRegion(); // Get the correct work at runtime
                if (region == null)
                    return;
                BufferedImage texture = renderer.renderRegion(new RegionFile(region.region.regionFile));
                if (!invalid.get()) {
                    region.texture = texture;
                    update.notifyObservers();
                }
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }

    protected RenderedRegion nextRegion() {
        Comparator<RenderedRegion> comp = (a, b) -> /*...*/);
        RenderedRegion min = null;
        for (Iterator<RenderedRegion> it = todo.iterator(); it.hasNext();) {
            RenderedRegion r = it.next();
            if (min == null || comp.compare(min, r) > 0)
                min = r;
        }
        todo.remove(min);
        return min;
    }
}