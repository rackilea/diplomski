public static Calendar[] cal = createCalendars();

private static Calendar[] createCalendars() {
    Calendar[] ret = new Calendar[2];
    ret[0] = Calendar.getInstance();
    ret[0].set(2012, 11, 10, 16, 30);
    ret[1] = Calendar.getInstance();
    ret[1].set(...);
    return ret;
}