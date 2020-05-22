public class Service {

    public static <E extends Enum<E>> void setServiceMode(E mode) {

    }

    // Or a pre-generics version.
    public static void setServiceMode2(Enum mode) {

    }
}

public enum SERVICE_MODE {

    LOGIN,
    LOGOUT;
}

public void test() {
    Service.setServiceMode(SERVICE_MODE.LOGIN);
    Service.setServiceMode2(SERVICE_MODE.LOGIN);
}