public static int h(int n) {
    System.out.println("h(" + n + ")");
    if (n == 0) {
        System.out.println("value: 0");
        return 0;
    } else {
        System.out.println("going down");
        int temp = h(n - 1) + 1;
        System.out.println("h(" + n + ") --> " + temp);
        return temp;
    }
}