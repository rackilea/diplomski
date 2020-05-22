public class Decimal {

    private static String REGEX = "^\\d{1,3}|\\d(([ ,]?\\d{3})*([.,]\\d{2}+)?$)";

    public static void main(String[] args) {
        String data[] = {"1000", "1,000", "1,000.00", "1000.00", "1000.00.00", "1,0.00", "1,000,00.00", "1,000,000.12"};

        Pattern.compile(REGEX);

        for (int i = 0; i < data.length; i++) {
            if (data[i].matches(REGEX)) {
                System.out.println(data[i] + " - valid");
            } else {
                System.out.println(data[i] + " - invalid");
            }
        }
    }

}