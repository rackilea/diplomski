import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author kanirmal
 */
public class HolidayPlanner {

    public static boolean leapYear(int year) {
        boolean leap = false;
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    leap = true;
                } else {
                    leap = false;
                }

            } else {
                leap = true;
            }

        } else {
            leap = false;
        }
        return leap;
    }

    public static int solution(int year, String startMonth, String endMonth,
            String firstDayOfYear) {

        ArrayList<String> days = new ArrayList<>();
        days.add("mon");
        days.add("twe");
        days.add("wed");
        days.add("thu");
        days.add("fri");
        days.add("sat");
        days.add("sun");

        ArrayList<String> month = new ArrayList<>();

        month.add("january");
        month.add("february");
        month.add("march");
        month.add("april");
        month.add("may");
        month.add("june");
        month.add("july");
        month.add("august");
        month.add("september");
        month.add("october");
        month.add("november");
        month.add("december");

        HashMap<String, Integer> mapMonth = new HashMap<>();
        mapMonth.put("january", 31);
        if (leapYear(year)) {
            mapMonth.put("february", 29);
        } else {
            mapMonth.put("february", 28);
        }
        mapMonth.put("march", 31);
        mapMonth.put("april", 30);
        mapMonth.put("may", 31);
        mapMonth.put("june", 30);
        mapMonth.put("july", 31);
        mapMonth.put("august", 31);
        mapMonth.put("september", 30);
        mapMonth.put("october", 31);
        mapMonth.put("november", 30);
        mapMonth.put("december", 31);

        int startMonthDays = 0;

        for (int i = 0; i <= month.indexOf(startMonth); i++) {
            startMonthDays += mapMonth.get(month.get(i));
        }

        int endMonthDays = 0;

        for (int i = 0; i <= month.indexOf(endMonth); i++) {
            endMonthDays += mapMonth.get(month.get(i));
        }

        int startDayNo = ((days.indexOf(firstDayOfYear) - 1) + ((startMonthDays % 7) - 1)) % 7;

        int endDayNo = ((days.indexOf(firstDayOfYear) - 1) + ((endMonthDays % 7) - 1) + mapMonth.get(endMonth)) % 7;

        int totalLeaveDays = mapMonth.get(startMonth)
                + (endMonthDays - startMonthDays);

        if (startDayNo != 0) {
            totalLeaveDays = totalLeaveDays - startDayNo;
        }

        if (endDayNo != 6) {
            totalLeaveDays = totalLeaveDays - endDayNo;
        }

        int totalWeek = totalLeaveDays / 7;

        return totalWeek;
    }
    public static void main(String args[])
    {
        int year = 2018;
        int no_of_weeks = 0;
        String start_month = "may";
        String end_month = "june";
        String firstDayOfYear = "mon";
        no_of_weeks = solution(year,start_month,end_month,firstDayOfYear);
        System.out.println("Total number of weeks spent during the vacation:"+no_of_weeks);
        System.out.println("solution::" + solution(2014, "may", "june", "wed"));

    }
}