public static <T> void processAll(Collection<T> items, Collection<? extends Processor<T>> processors) {
    Iterator<T> i = items.iterator();
    Iterator<? extends Processor<T>> p = processors.iterator();
    while(i.hasNext() && p.hasNext())
        p.next().process(i.next()); 
}