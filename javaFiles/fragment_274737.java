package stackoverflow1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class User {
    private String mUserName;
    private String mPassword;

    public User(String userName, String password) {
        mUserName = userName;
        mPassword = password;
    }

    public String getUserName() { return mUserName; }
    public String getPasword() { return mPassword; }

    @Override
    public String toString() {
        String info = String.format("Name: %s Pwd: %s", mUserName, mPassword);
        return info;
    }
}

public class Main {
    static List<User> users = new ArrayList<>();        

    static void addUser(Scanner scanner) {
        String userName, password;

        println("UserName: ");
        userName = scanner.nextLine();
        println("Password: ");
        password = scanner.nextLine();

        println("Adding a new user now.");
        users.add(new User(userName, password));        
    }

    public static void main(String[] args) {        
        Scanner scanner = new Scanner(System.in);
        boolean done = false;

        while (!done) {
            println("Add user name and password. Type quit when you are done.");
            String userInput = scanner.nextLine();

            switch (userInput) {
                case "adduser":
                    addUser(scanner);
                    break;

                case "quit":
                    done = true;
                    break;

                default:
                    println("Unknown input!");
            }
        }

        println("--- Users Information ---");
        users.forEach(user -> println(user.toString()));
    }

    static void println(String msg) {
        System.out.println(msg);
    }
}