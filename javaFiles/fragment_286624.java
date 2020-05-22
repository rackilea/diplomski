class Test {
    public static void main(String[] args) {
        f("", 3, 3);
    }
    static void f(String prefix, int length, int sum) {
        if (length == 0) {
            if(sum == 0) {
                System.out.println(prefix);
            }
        } else {
            for(int i=0; i<=sum && i<10; i++) {
                f(prefix + i, length-1, sum-i);
            }
        }
    }
}