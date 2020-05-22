public interface PassengerTransporter {
    void someSpecificMethodToAllPassengerTransporters();
}

public class SubClass1 implements PassengerTransporter {
    void someSpecificMethodToAllPassengerTransporters() {
        // TODO : implement this
    }
}

public class SubClass2 implements PassengerTransporter {
    void someSpecificMethodToAllPassengerTransporters() {
        // TODO : implement this
    }
}

if (plane instanceof PassengerTransporter) {
    PassengerTransporter p = (PassengerTransporter) plane;
    p.someSpecificMethodToAllPassengerTransporters();
}