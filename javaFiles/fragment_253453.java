import java.math.BigDecimal;

public class Greedy_Money_BigInteger {
    public static int[] optimal_change(BigDecimal[] currency, BigDecimal amount) {

        int[] count = new int[currency.length];

        for (int i = 0; i < currency.length; i++) {
            //if (amount >= currency[i]) {
            if (amount.compareTo(currency[i]) >= 0) {
                amount = amount.subtract(currency[i]);
                count[i]++;
                i--;
            }
            if (amount.compareTo(BigDecimal.valueOf(0)) <= 0) {
                break;
            }
        }

        return count;
    }


    public static void main(String[] args) {

        BigDecimal[] american_currency = {BigDecimal.valueOf(100),BigDecimal.valueOf(50),BigDecimal.valueOf(20),BigDecimal.valueOf(10),BigDecimal.valueOf(5),BigDecimal.valueOf(1),BigDecimal.valueOf(0.25),BigDecimal.valueOf(0.10),BigDecimal.valueOf(0.05),BigDecimal.valueOf(0.01)};
        //Japanese currency: https://www.boj.or.jp/en/note_tfjgs/note/valid/index.htm/
        BigDecimal[] japanese_currency = {BigDecimal.valueOf(10000),BigDecimal.valueOf(5000),BigDecimal.valueOf(2000),BigDecimal.valueOf(1000),BigDecimal.valueOf(500),BigDecimal.valueOf(100),BigDecimal.valueOf(50),BigDecimal.valueOf(10),BigDecimal.valueOf(5),BigDecimal.valueOf(1)};

        BigDecimal american_change_value = BigDecimal.valueOf(78.31);
        BigDecimal japanese_change_value = BigDecimal.valueOf(793043);

        int[] american_change = optimal_change(american_currency, american_change_value);
        int[] japanese_change = optimal_change(japanese_currency, japanese_change_value);

        System.out.println("Optimal change for: $" + american_change_value.toString());
        for (int i = 0; i < american_currency.length; i++) {
            if (american_change[i] > 0) {
                if (i <= 5) {
                    System.out.println(Integer.toString(american_change[i]) + " $" + american_currency[i].toString());
                } else {
                    System.out.println(Integer.toString(american_change[i]) + " " + american_currency[i].toString() + "¢");
                }
            }
        }
        System.out.println("--------------------------");
        System.out.println("Optimal change for: ¥" + japanese_change_value.toString());
        for (int i = 0; i < japanese_currency.length; i++) {
            if (japanese_change[i] > 0) {
                System.out.println(Integer.toString(japanese_change[i]) + " ¥" + japanese_currency[i].toString());
            }
        }


    }
}