public class DemoApplication {

    public static void main(String[]args) {
        Map<BigDecimal, BigDecimal> map = new HashMap<>();
        // ...

        if (map.containsKey(BigDecimal.valueOf(400))) {
            System.out.println(map.keySet());
        }
    }

}