package test;

import java.sql.Timestamp;
import java.util.Date;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        Timestamp a = null;
        Date now = new Date();
        Timestamp b = new Timestamp(now.getTime());

        a = update(a, b);
        System.out.println(a); // returns "null", why?
    }

    /**
     * Sets the newer timestamp to the old if it is possible.
     * @param a an old timestamp
     * @param b a new timestamp
     */
    private static Timestamp update(Timestamp a, Timestamp b) {
        if(b == null) {
            //nothing
        } else if(a == null) {
            a = b;
        } else if(a.after(b)) {
            a = b;
        }

        return a;
    }
}