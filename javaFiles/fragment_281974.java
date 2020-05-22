class NumberTest {
    public static void main(String[] args) {
        String y = "100,24";
        float num = Float.parseFloat(y.replace(',','.'));
        System.out.println(num);
    }
}