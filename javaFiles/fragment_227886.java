public class Fair extends Event {
    private int numOfExib;
    private String exibType;

    /** default constructor */
    public Fair() {
        // no need to explicitly call default constructor
        numOfExib = 0; // unnecessary, but I like to explicitly initialize
        exibType = ""; // this is necessary to avoid a null value
    }

    /** copy constructor */
    public Fair(Fair other) {
        super(other); // parent class's copy constructor
        numOfExib = other.numOfExib;
        exibType = other.exibType;
    }
    ...
}