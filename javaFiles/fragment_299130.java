public abstract class Calendar {
    public static int DAY_OF_WEEK = 7;  // a constant that never changes

    // ..... many more fields

    // field name may be different
    private int dayOfWeek = 0; // or some other default value

    public void set(...) {
        // sets the dayOfWeek value
    }

    public int get(int ) {
        if (field == DAY_OF_WEEK) {
            return this.dayOfWeek;
        }

        // .... more code

    }

    public String toString() {
        return .... + "DAY_OF_WEEK:" + dayOfWeek + .....;
    }
}