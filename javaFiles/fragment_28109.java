public class Authenticator {

    public boolean authenticate(String user, String pass) {
        System.out.println("User: '" + user + "', pass: '" + pass + "'");
        return true;
    }

}