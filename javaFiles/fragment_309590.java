public static void main(String[] args) throws ParseException {
    DateTime date1 = new DateTime("1492-10-12");
    DateTime date2 = new DateTime("1992-10-12");
    int yrs = computeDiffInYears(date1, date2);
    System.out.println(yrs);
}

private static int computeDiffInYears(DateTime date1, DateTime date2) {
    return Years.yearsBetween(date1, date2).getYears();
}