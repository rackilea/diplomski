public class RealConstants {
    final public static int MAX_PAGE_SIZE = 50;
}
public enum IntegerConstants
{
    MAX_PAGE_SIZE(RealConstants.MAX_PAGE_SIZE);//reuse the constant
    private final int value;

    private IntegerConstants(int con) {
        this.value = con;
    }

    public int getValue() {
        return value;
    }
}