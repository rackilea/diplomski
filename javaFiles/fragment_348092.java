class Test1 {
    public static void main(String[] args) {
        int a = 5 % 3;  // 2
        int b = 5 / 3;  // 1
        System.out.println("5%3 produces " + a +
                " (note that 5/3 produces " + b + ")");

        int c = 5 % (-3);  // 2
        int d = 5 / (-3);  // -1
        System.out.println("5%(-3) produces " + c +
                " (note that 5/(-3) produces " + d + ")");

        int e = (-5) % 3;  // -2
        int f = (-5) / 3;  // -1
        System.out.println("(-5)%3 produces " + e +
                " (note that (-5)/3 produces " + f + ")");

        int g = (-5) % (-3);  // -2
        int h = (-5) / (-3);  // 1
        System.out.println("(-5)%(-3) produces " + g +
                " (note that (-5)/(-3) produces " + h + ")");
    }
}