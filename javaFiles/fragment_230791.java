public class Main {

    private static Device arr[];

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        init();
        arr[0].print();
        arr[1].print();
    }

    public static void init() {
        arr = new Device[2];
        arr[0] = new Printer();
        arr[1] = new UsbMem();
    }
}

public interface Connectable {
    public static final String name = ":USB";
    public abstract void connect();
}

public abstract class Device implements Connectable {
    public abstract void print();
}

public class Printer extends Device {

    public void print() {
        System.out.println("It's a printer");
    }

    public void connect() {
        System.out.println(name + "connect with printer");
    }
}

public class UsbMem extends Device {

    public void print() {
        System.out.println("USB memory");
    }

    public void connect() {
        System.out.println(name + "connect with usb memory");
    }
}