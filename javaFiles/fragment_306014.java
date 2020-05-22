import java.util.Random;

public class Test{

    public static void print(String str) {
      System.out.print(str);
    }

    public static int randomInt(int min, int max) {
        Random rand = new Random(System.currentTimeMillis());
        int randomNum = rand.nextInt((max-min)+1) - min;
        return randomNum;
    }

    public static void main(String[] args) throws InterruptedException {
        String strings = "abcdefghijklmnopqrstuvwxyz1234567890!@#$%&()ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int len = strings.length() - 1;
        StringBuilder outputString = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            Double test = new Double(randomInt(0, len));
            Integer value = test.intValue();
            if (value <= len) {
                //print(value.toString()); For testing purposes
                outputString.append(strings.charAt(value));
                Thread.sleep(1);
            }
            else {i--;}
        }
        print(outputString + "\n");
    }
}