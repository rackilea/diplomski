/**
 * Prints an Object and then terminates the line.  This method calls
 * at first String.valueOf(x) to get the printed object's string value,
 * then behaves as
 * though it invokes <code>{@link #print(String)}</code> and then
 * <code>{@link #println()}</code>.
 *
 * @param x  The <code>Object</code> to be printed.
 */
public void println(Object x) {
    String s = String.valueOf(x);
    synchronized (lock) {
        print(s);
        println();
    }
}