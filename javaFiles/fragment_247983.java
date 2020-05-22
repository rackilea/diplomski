import java.io.IOException;

public class UserAccount {

    public static void main(String[] args){

        String userName = "foo";

        try {

            Runtime.getRuntime().exec("net user " + userName + " /add");

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}