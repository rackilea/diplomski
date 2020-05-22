import java.io.*;
import java.text.*;
import java.util.*;

public class Foo {

    public static void main(String[] args)
    throws Exception
    {
        BufferedReader byMinute = new BufferedReader(
            new InputStreamReader(
            new FileInputStream("by-minute.csv")));

        BufferedReader bySecond = new BufferedReader(
            new InputStreamReader(
            new FileInputStream("by-second.csv")));

        String byMinuteLine = byMinute.readLine();
        String bySecondLine = bySecond.readLine();

        while (byMinuteLine != null || bySecondLine != null) {

            /* If either file is done, print lines from the other file */
            if (byMinuteLine == null) {
                System.out.println(indicize(bySecondLine));
                bySecondLine = bySecond.readLine();
            } else if (bySecondLine == null) {
                System.out.println(indicize(byMinuteLine));
                byMinuteLine = byMinute.readLine();
            } else {
                /* Otherwise print the earlier entry */
                long minuteTime = getTimeStamp(byMinuteLine);
                long secondTime = getTimeStamp(bySecondLine);

                if (secondTime < minuteTime) {
                    System.out.println(indicize(bySecondLine));
                    bySecondLine = bySecond.readLine();
                } else {
                    System.out.println(indicize(byMinuteLine));
                    byMinuteLine = byMinute.readLine();
                }
            }
        }

    }

    static long getTimeStamp(String line) {
        return Long.valueOf(line.split(",")[0]);
    }

    static String indicize(String line) {
        return ((getTimeStamp(line) - 1394589660) / 20)
            + line.substring(line.indexOf(","));
    }

}