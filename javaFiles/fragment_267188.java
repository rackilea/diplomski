public static void main(String[] args) {
    int plan = getPlanFromUser();
    int month = getMonthFromUser();
    int hours = getHoursFromUser(month);
    evaluateSavings(plan, month, hours);
}