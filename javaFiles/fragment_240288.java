public class userAnalytic {

    public static void main(String[] args) {
        boolean additionalLogging = false;
        System.out.println(additionalLogging);
        for (int i = 0; i <= 10; i++) {
            System.out.println(i);
            if (i == 5 && additionalLogging) {
                System.out.println("We found 5");
            }
            if (i == 2) {
                additionalLogging = true;
            }
            if (i == 8 && additionalLogging) {
                System.out.println("8 has been found");
            }
        }
    }
}