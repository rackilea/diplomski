public enum Wealth {

    BROKE(0),
    DESTITUTE(10),
    POOR(100),
    MIDDLE_CLASS(10000),
    RICH(100000),
    MILLIONAIRE(1000000),
    BILLIONAIRE(1000000000);

    private final int value;

    private Wealth(final int value) {
        this.value = value;
    }

    public final int getValue() {
        return value;
    }

    /**
     * @param v
     *        the value we're looking for
     * @return Wealth
     */
    public static Wealth lookup(final int v) {
        final Wealth[] a = Wealth.values();
        int min = 0;
        int max = a.length  - 1;
        int i;
        do {
            i = (min + max) / 2;
            final int av = a[i].value;
            if (v < av) {
                max = i;
            } else if (v > av) {
                if (i + 1 < a.length && v < a[i + 1].value) {
                    break;
                }
                min = i + 1;
            }
        } while (v != a[i].value && min < max);
        if (min == max) {
            return a[max];
        }
        return a[i];
    }

}