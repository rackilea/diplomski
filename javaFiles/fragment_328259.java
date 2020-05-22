public class friday {
    private static final int DAYS_IN_WEEK = 7;
    private static final int MONTHS_IN_YEAR = 12;

    private static void updateDays(int[] days, int day) {
        checkIsInRange(0, year, DAYS_IN_WEEK);
        days[(day + 4) % DAYS_IN_WEEK]++;
    }

    private static boolean isLeapYear(int year) {
       checkIsInRange(0, year, MONTHS_IN_YEAR);
       return (year % 4 == 0) && (year % 100 != 0 || year % 400 == 0);
    }

    private static void checkIsInRange(int inclusiveLowerBound, int toTest, int exclusiveUpperBound) {
         if (toTest < inclusiveLowerBound || exclusiveUpperBound <= toTest) throw new IllegalArgumentException(toTest + " not in [" + inclusiveLowerBound + ", " + exclusiveUpperBound + "]");                 
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("friday.in"));
        PrintWriter pw= new PrintWriter(new FileWriter("friday.out"));
        int years = Integer.parseInt(br.readLine());

        int month = 1;
        int day = 1;
        int months = MONTHS_IN_YEAR*years;
        int test = 0;
        int year = 1900;

        int days = int[DAYS_IN_WEEK];
        int[] incrementForMonth = { 3, 3, 1, 3, 2, 3, 2, 3, 3, 2, 3, 2 }; 

        for(int i = 0; i < months; i++) {
            test = isLeapYear(year) ? 1 : 0;

            updateDays(days, day);
            if (month != 2 || test == 1) {
                day = (day + incrementForMonth[month]) % DAYS_IN_WEEK;
            }
            if (month == 0) {
                year++;
            }
        }

        month = (month + 1) % MONTHS_IN_YEAR;
    }
    pw.println(saturday + " " + sunday + " " + monday + " " + tuesday + " " + wedensday+ " " + thursday + " " + friday);
    pw.close();
}