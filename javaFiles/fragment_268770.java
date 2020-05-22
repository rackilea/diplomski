public class MergedEventStream implements EventStream {

    private ArrayList<EventStream> merged = new ArrayList<EventStream>();
    private int nextIndex = -1;

    public MergedEventStream(Collection<EventStream> toMerge) {
        merged.addAll(toMerge);
        findNext();
    }

    public Event peek() {
        if (nextIndex == -1 && findNext() == false) {
           throw new NoSuchElementException();
        } else {
           Event e = merged.get(nextIndex).peek();
           return e;
        }
    }

    public Event peek() {
        if (nextIndex == -1 && findNext() == false) {
           throw new NoSuchElementException();
        } else {
           Event e = merged.get(nextIndex).next();
           findNext();
           return e;
        }
    }

    /**
     * iterates over merged, and for each stream with an available event,
     * adds it to a sorted TreeMap<Event, Integer> (sorting by any event field; integer
     * is stream index in arrayList)
     * if set is not empty, returns 'true', and sets nextIndex to the stream index
     * otherwise, returns 'false', and sets nextIndex to -1
     */
    private boolean findNext() {
        // ...
    }
}