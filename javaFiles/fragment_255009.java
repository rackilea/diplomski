import java.util.*;
import java.util.regex.*;
import java.lang.*;
import java.io.*;

class Ideone
{
    private static final String EMAIL_PATTERN_New =
            "^[\\w+-]+(?:\\.[\\w-]+)*@(?:admin|firmware|repair|service)(?:\\.[A-Za-z0-9]+)*\\.[A-Za-z]{2,}$";

    public static void main (String[] args) throws java.lang.Exception
    {
        String email = "xxxx@admin.com";
        String email1 = "xxxx@ad.com";
        String email2 = "test@irm.jdsu.com";

        System.out.println(email.matches(EMAIL_PATTERN_New));     // true
        System.out.println(email1.matches(EMAIL_PATTERN_New));    // false
        System.out.println(email2.matches(EMAIL_PATTERN_New));    // false
    }
}