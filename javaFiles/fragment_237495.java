countDownInMiddle("", 9, "");

private static void countDownInMiddle(String start, int n, String end) {
    if (n < 0) {
        return;
    }
    System.out.println(start + n + end);
    countDownInMiddle(start + n, n - 1, n + end);
}