public class Car {

    private String driver;

    public Car( String driver ) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "Car (" + driver + ")";
    }

}