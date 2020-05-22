public class Game {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int Naruto = 0;
        int DragonBallZ = 1;
        int Batman = 0;
        int Freedom = 0;
        int righthand = 1;
        int lefthand = 1;

        if (Naruto == 0) {
            if (lefthand == 0) {
                System.out.println("The command 0 has been used...");
                System.out.println("Processing...");
                System.out.println("Accessing Game Server...");
                System.out.println("Success!");
                System.out.println("You have been given the 'Kunai'");
            } else if (righthand == 1) {
                System.out.println("The command 1 has been used...");
                System.out.println("Processing...");
                System.out.println("Accessing Game Server...");
                System.out.println("Success!");
                System.out.println("You have been given the 'Shurikan'");
            }
        } else if (DragonBallZ == 1) { //Changed if to else if
            if (lefthand == 0) {
                System.out.println("The command 2 has been used...");
                System.out.println("Processing...");
                System.out.println("Accessing Game Server...");
                System.out.println("Success!");
                System.out.println("You have been given the 'Kaioken' Ability");
            } else if (righthand == 1) {
                System.out.println("The command 3 has been used...");
                System.out.println("Processing...");
                System.out.println("Accessing Game Server...");
                System.out.println("Success!");
                System.out.println("You have been given the 'Super Saiyan 4'     Ability");
            }
        } else if (Batman == 2) { //Changed if to else if
            if (lefthand == 0) {
                System.out.println("The command 4 has been used...");
                System.out.println("Processing...");
                System.out.println("Accessing Game Server...");
                System.out.println("Success!");
                System.out.println(" You have been given the 'Batarang' ");
            } else if (righthand == 1) {
                System.out.println("The command 5 has been used...");
                System.out.println("Processing...");
                System.out.println("Accessing Game Server...");
                System.out.println("Success!");
                System.out.println(" You have been given the 'Keen Eyes'     Ability");
            }
        } else if (Freedom == 3) { //Changed if to else if
            if (lefthand == 0) {
                System.out.println("The command 6 has been used...");
                System.out.println("Processing...");
                System.out.println("Accessing Game Server...");
                System.out.println("Success!");
                System.out.println(" You have been given the 'Rope' ");
            } else if (righthand == 1) {
                System.out.println("The command 7 has been used...");
                System.out.println("Processing...");
                System.out.println("Accessing Game Server...");
                System.out.println("Success!");
                System.out.println(" You have been given the 'Knife' ");
            }
        }
    }
}