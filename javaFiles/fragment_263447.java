/**
 * Safely compare two dates, null being considered "greater" than a Date
 * @return the earliest of the two
 */
public static Date least(Date a, Date b) {
    return a == null ? b : (b == null ? a : (a.before(b) ? a : b));
}