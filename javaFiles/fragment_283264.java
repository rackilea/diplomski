import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TimePartition {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            System.out.println("Enter a positive number to decompose");
            String input = br.readLine();
            if (input.equals("")) break;
            float inputAsFloat = Float.parseFloat(input);
            if (inputAsFloat == 0.0) break;

            // the input is an integral day count, with a possible fractional part representing time as a fraction of one day
            int totalDays = (int)inputAsFloat;
            int totalSeconds = (int)((inputAsFloat-totalDays)*60.0*60.0*24.0);

            // decompose totalDays into date fields
            int years = 0;
            int months = 0;
            int weeks = 0;
            int days = 0;

            // ignores leap years
            years = (int)totalDays/365;
            totalDays %= 365;

            // assumes all months have 30 days
            months = (int)totalDays/30;
            totalDays %= 30;

            weeks = (int)totalDays/7;
            totalDays %= 7;

            days = (int)totalDays;

            // decompose totalSeconds into time fields
            int hours = 0;
            int minutes = 0;
            int seconds = 0;

            hours = (int)totalSeconds/3600;
            totalSeconds %= 3600;

            // ignores leap seconds
            minutes = (int)totalSeconds/60;
            totalSeconds %= 60;

            seconds = (int)totalSeconds;

            System.out.println("The number "+inputAsFloat+" is "+years+" years, "+months+" months, "+weeks+" weeks, "+days+" days, "+hours+" hours, "+minutes+" minutes, "+seconds+" seconds.");

        } // end while

    } // end main()

} // end class TimePartition