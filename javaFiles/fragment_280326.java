class Reservation {
    // name these variables properly!
    private String someValue1;
    private String someValue2;
    private String someValue3;

    @Override // this returns a formatted string representation of a reservation
    public String toString() {
        return "someValue1: " + someValue1
             + "\nsomeValue2: " + someValue2
             + "\nsomeValue3: " + someValue3;
    }

    public Reservation(String someValue1, String someValue2, String someValue3) {
        this.someValue1 = someValue1;
        this.someValue2 = someValue2;
        this.someValue3 = someValue3;
    }
}