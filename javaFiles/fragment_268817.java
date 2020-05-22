package java.util;

public class TestTripwire {
    public static void main(String[] args) {
        Tripwire.trip(Object.class, "sss");
    }
}