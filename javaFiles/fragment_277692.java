import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class FSD {

    static int monthDays_notleapyear[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        int d1 = myObj.nextInt();
        int m1 = myObj.nextInt();
        int y1 = myObj.nextInt();
        int d2 = myObj.nextInt();
        int m2 = myObj.nextInt();
        int y2 = myObj.nextInt();

        long daysBetween = ChronoUnit.DAYS.between(LocalDate.of(y1, m1, d1), LocalDate.of(y2, m2, d2));

        System.out.println("Using Java Date: " + daysBetween);
        get_Difference(d1, m1, y1, d2, m2, y2);
    }

    static int get_Difference(int d1, int m1, int y1, int d2, int m2, int y2) {
        // int n1 = y1 * 365 + d1;

        int yearDiff = y2 - y1 - 1;

        int totalDays = yearDiff * 365;

        int numberOfLeapDays = numberOfLeapYearBetween(y1, y2);

        // Check if (m1 == 2 and d1 <=29 ) or if m1 == 1, increment by 1.
        if ((m1 <= 2 && d1 <= 29) || m1 == 1) {

            boolean isStartLeapYear = isLeapYear(y1);
            if (isStartLeapYear) {
                numberOfLeapDays++;
            }
        }

        // Check if m2 is greater than 3. If yes, check if leap year, increment by 1.
        if (m2 >= 3) {
            boolean isEndLeapYear = isLeapYear(y2);
            if (isEndLeapYear) {
                numberOfLeapDays++;
            }
        }

        int remainingDays = 0;
        for (int i = m1; i <= 12; i++) {

            if (i == m1) {
                remainingDays = remainingDays + (monthDays_notleapyear[i - 1] - d1);
            } else {

                remainingDays = remainingDays + monthDays_notleapyear[i - 1];
            }
        }

        for (int i = m2; i > 0; i--) {
            if (i == m2) {
                remainingDays = remainingDays + d2;
            } else {
                remainingDays = remainingDays + monthDays_notleapyear[i - 1];
            }
        }

        totalDays = totalDays + numberOfLeapDays + remainingDays;

        System.out.println("Total Days: " + totalDays);

        return totalDays;
    }

    private static boolean isLeapYear(int year) {

        boolean leap = false;

        if (year % 4 == 0) {
            if (year % 100 == 0) {
                // year is divisible by 400, hence the year is a leap year
                if (year % 400 == 0)
                    leap = true;
                else
                    leap = false;
            } else
                leap = true;
        } else
            leap = false;

        return leap;

    }

    /**
     * Get Number of Leap Years excluding startYear and endYear.
     * 
     * @param startYear
     * @param endYear
     * @return
     */
    private static int numberOfLeapYearBetween(int startYear, int endYear) {

        int counter = 0;
        while (startYear < endYear - 1) {
            startYear++;
            boolean isLeapYear = isLeapYear(startYear);
            if (isLeapYear) {
                counter++;
            }
        }
        return counter;

    }

}