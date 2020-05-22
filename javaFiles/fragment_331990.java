public static void main (String[] args) {

    int count = 0;
    // dow = 2, since 1.1.1901 was a Thuesday (2)
    for (int year = 1901, dow = 2; year <= 2000; ++year)
    {
        for (int month = 1; month <= 12; ++month)
        {
            if (dow == 0) {
                // System.out.println ("Date: " + year + "-" + month);
                ++count;
            }
            dow = (dow + numberOfDays (month, year)) % 7;
        }
    }
    System.out.println ("Number of Sundays that fell on the first of the month from: 1/Jan/1901 - 31/Dec/2000: " + count);
}