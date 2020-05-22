public class EnumIntMap<E extends Enum<E>> {

    private final int[] values;

    public EnumIntMap(Class<E> cls)
    {
        this.values = new int[cls.getEnumConstants().length];
    }

    public int getValue(E a)
    {
        return this.values[a.ordinal()];
    }

    public void setValue(E a, int value)
    {
        this.values[a.ordinal()] = value;
    }
}