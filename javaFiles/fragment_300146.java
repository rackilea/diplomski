import java.util.Random;

public class AccountPicker {

    public static void main(String[] args) throws InterruptedException {

        String password = "";
        String[] accounts = { "a", "b", "c" };
        String[] passwords = { "password", "Password", "PASSWORD" };

        Random r = new Random();
        int assigned = r.nextInt(3);

        System.out.println("account: " + accounts[assigned] + ", password: " + passwords[assigned]);
    }
}