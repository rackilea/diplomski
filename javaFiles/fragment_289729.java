public static <E extends Enum<?>> void iterateOverEnumsByInstance(E e)
{
    iterateOverEnumsByClass(e.getClass());
}

public static <E extends Enum<?>> void iterateOverEnumsByClass(Class<E> c)
{
    for (E o: c.getEnumConstants()) {
        System.out.println(o + " " + o.ordinal());
    }
}