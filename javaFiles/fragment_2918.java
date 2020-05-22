class Main {
    public static void main(String[] args) {
        int a = 1234;
        int b = 567890;
        int c = (int) Math.pow(10, Math.floor(Math.log10(b))+1)*a + b;
        System.out.println(c);
    }
}