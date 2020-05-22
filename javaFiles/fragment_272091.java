private static class EnumByNameComparator implements Comparator<Enum<?>>
{
    public static final Comparator<Enum<?>> INSTANCE = new EnumByNameComparator();

    public int compare(Enum<?> enum1, Enum<?> enum2)
    {
        if (enum2.toString().equals(MSDApplication.getAppContext().getString(R.string.no_selected)))
            return Integer.MAX_VALUE;
        else if (enum1.toString().equals(MSDApplication.getAppContext().getString(R.string.no_selected)))
            return Integer.MIN_VALUE;
        else
            return enum1.toString().compareTo(enum2.toString());
    }
}