class Event implements Comparable< Event > {
    // Member field variable.
    public LocalDateTime when ;

    // Constructor
    public Event( LocalDateTime localDateTime ) {
        this.when = localDateTime ;
    }

    // Implements `Comparable` interface.
    @Override
    public int compareTo( Event that ) {
        return this.when.compareTo( that.when ) ;
    }

    // Override `Object.toString` for better reporting of the value of this object.
    @Override
    public String toString() {
        return this.when.toString() ;
    }
}