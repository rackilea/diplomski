public enum BloodTest {
    AAA, BBB, CCC;

    private static String[] names;

    public static void setNames(String[] names) {
        if (BloodTest.names != null)
            throw new IllegalStateException("You can only set the names once");
        if (names.length != values().length)
            throw new IllegalArgumentException("Wrong number of names");
        BloodTest.names = names;
    }

    @Override
    public String toString() {
        return names[ordinal()];
    }
}