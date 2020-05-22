/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.regex.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
    public static void main (String[] args) throws java.lang.Exception
    {
        String s = "This is An Image File [LoadImage:'image1.jpg'] this is Another Image [LoadImage:'image2.jpg']";

        Pattern p = Pattern.compile("\\[LoadImage:(.*?)\\]");
        Matcher m = p.matcher(s);

        while(m.find()) {
            System.out.println(m.group(1));
        }
    }
}