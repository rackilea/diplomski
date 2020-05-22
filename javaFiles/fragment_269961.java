private static double calculateTotalGrade(double grade, double examValue) {
    return grade * 100 / examValue;
}

private static boolean hasFailed(double grade) {
    return grade < 50;
}