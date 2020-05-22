public static void main(String[] args) {
    String eq = "15+5cdf-45+90$%#@";
    long sum = eval(eq);
    System.out.println("sum: " + sum);
}

private static long eval(String eq) {
    int sign = +1;
    long num = 0, sum = 0;
    for (int i = 0; i < eq.length(); i++) {
        char ch = eq.charAt(i);
        if (ch >= '0' && ch <= '9') {
            num = num * 10 + ch - '0';
        } else if (ch == '-' || ch == '+') {
            sum += sign * num;
            sign = ch == '-' ? -1 : +1;
            num = 0;
        }
    }
    sum += sign * num;
    return sum;
}