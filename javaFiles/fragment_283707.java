public class Base {
    private static final int ERROR_1 = 0;
    private static final int ERROR_2 = 1;
    private static final int ERROR_3 = 2;
    protected static final int LAST_ERROR = ERROR_3;
}

public class OffSpring extends Base {
    private static final int NEW_ERROR_1 = Base.LAST_ERROR + 1;
}