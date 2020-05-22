public class FinalMethods {
    public static void main(String[] args) {
        String[] names = {"Barry", "Lindsey", "Arron", "Brent"};
        double[] hours = {40.0, 37.5, 39.5, 18.5};
        double[] rate = {15.67, 8.90, 8.90, 12.33};
        double[] prevHrs = {
                32.0, 40.0, 39.0,
                28.5, 31.5, 38.0,
                40.0, 24.0, 36.0,
                40.0, 40.0, 22.5
        };
        double[] monthHours;
        {
            // we have name.length employees, and for each 3 prevHrs entries and 1 hours entry
            monthHours = new double[names.length * 4];
            for (int i = 0; i < names.length; i++) {
                // append/copy range of 3 prevHrs entries to monthHours
                System.arraycopy(prevHrs, i * 3, monthHours, i * 4, 3);
                // append/copy range of 1 hours entries to monthHours
                System.arraycopy(hours, i, monthHours, i * 4 + 3, 1);

                // equivalent to:
                /*
                    monthHours[i * 4] = prevHrs[i * 3];
                    monthHours[i * 4 + 1] = prevHrs[i * 3 + 1];
                    monthHours[i * 4 + 2] = prevHrs[i * 3 + 2];
                    monthHours[i * 4 + 3] = hours[i];
                */
            }
        }
        int mostHoursIndex = FinalMethods.getHighest(hours);
        double pay[] = FinalMethods.calculatePay(hours, rate);
        double totalPay[] = FinalMethods.calculateMonthPay(monthHours, rate);

        // most worked
        System.out.printf("The employee who worked most hours is %s with %.2f hours\n", names[mostHoursIndex], hours[mostHoursIndex]);

        System.out.println();

        // print pay table
        System.out.println("\n-- Employee Pay --\n");
        System.out.printf("%-10s %-10s %-10s %-10s\n", "Name", "Hours", "Rate", "Total");
        System.out.println();
        for (int i = 0; i < names.length; i++) {
            System.out.printf("%-10s %-10.2f %-10.2f %-10.2f\n", names[i], hours[i], rate[i], pay[i]);
        }

        System.out.println();

        // print monthly pay table
        System.out.println("\n-- Employee Monthly Pay --\n");
        System.out.printf("%-10s %-10s\n", "Name", "Total");
        System.out.println();
        for (int i = 0; i < names.length; i++) {
            System.out.printf("%-10s %-10.2f\n", names[i], totalPay[i]);
        }
    }

    public static int getHighest(double... values) {
        // result will be -1 for empty arrays
        int result = -1;
        // EVERY value should be > max when starting, thus:
        double max = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < values.length; i++) {
            double value = values[i];
            if (value > max) {
                // found a higher entry, mark index and update max
                max = value;
                result = i;
            }
        }
        // return index of highest entry
        return result;
    }

    public static double[] calculatePay(double[] hours, double[] rate) {
        double[] result = new double[rate.length];
        // for each employee
        for (int i = 0; i < result.length; i++) {
            // sum his hours (1 entry) * his rate
            result[i] = hours[i] * rate[i];
        }
        return result;
    }

    public static double[] calculateMonthPay(double[] monthHours, double[] rate) {
        double[] result = new double[rate.length];
        // for each employee
        for (int i = 0; i < result.length; i++) {
            // sum his monthHours (4 entries) * his rate
            double monthPay = 0;
            for (int j = 0; j < 4; j++) {
                monthPay += monthHours[i * 4 + j] * rate[i];
            }

            result[i] = monthPay;
        }
        return result;
    }
}