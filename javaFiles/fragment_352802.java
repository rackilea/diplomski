public class Event implements Comparable {
    …
    @Override
    public int compareTo( Event otherEvent ) {
        return this.start.compareTo( otherEvent.start ) ;
    }