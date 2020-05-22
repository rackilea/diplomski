public class Main
{
    public static void main(String[] args) {

        Main main = new Main();
        System.out.println(main.addInteger(5, 5));
    }

    public Long addInteger(Integer a, Integer b) {
        Integer sum = a + b;
        return sum.longValue();
    }
}