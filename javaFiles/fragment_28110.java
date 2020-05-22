public class Main {

    public static void main(String[] args) {

        Authenticator authenticator = new Authenticator();

        boolean status = authenticator.authenticate("Yaneeve", "12345");
        System.out.println("Status: '" + status + "'");
    }

}