import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {

        Random rand = new Random();
        Scanner in = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);


        boolean running = true;
        int hitPoints;
        int choice;
        String name;

        // Vehicle Vehicle = new Vehicle();
        Player Player = new Player();
        Enemy Enemy = new Enemy();

        Player.name();
        //   Vehicle.number();
        Player.hitPoints();

        name = Player.name;
        int enemyHealth;

        GAME:
        while (running) {

            String[] enemies = {"Skeleton", "Zombie", "Warrior", "Assassin", "Reaper", "Archer"};
            String enemy = enemies[rand.nextInt(enemies.length)];
            enemyHealth = rand.nextInt(500) + 250;
            Player.enemyHealth = enemyHealth;
            System.out.println("\n*# " + enemy + " appeared! #*");

            hitPoints = Player.hitPoints;

            while (enemyHealth > 0) {

                enemyHealth = Player.enemyHealth;
                if (enemyHealth < 1) {
                    break;
                }

                if (hitPoints < 1) {
                    System.out.println("\nYour car has been destroyed");
                    break;
                }


                hitPoints = Player.hitPoints;

                System.out.println("\nYour car has " + hitPoints + " health ");
                System.out.println("Enemy car has " + enemyHealth + " health ");

                System.out.println("\n1. Bump enemy car");
                System.out.println("2. Heal your car");
                System.out.println("3. Avoid enemy car");
                int userChoice = in.nextInt();

                switch (userChoice) {
                    case 1:
                        Player.attack();
                        break;
                    case 2:

                    case 3:
                        System.out.println("You barely avoided the enemy car");
                        break;

                }
            }
            if (hitPoints < 1) {
                System.out.println("\nGame Over");
                break;
            }
            if (enemyHealth < 1) {

                hitPoints = Player.hitPoints;
                name = Player.name;
                System.out.println(" \nEnd Fight Result: \n");
                System.out.println(" # " + enemy + " was defeated! #");
                System.out.println(" # You have " + hitPoints + " HP left. #");

                System.out.println("\nWhat would you like to do " + name + " ?");
                System.out.println("1. Continue Fighting");
                System.out.println("2. Exit Dungeon");

                choice = in.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("\nYou continue your adventure!");
                        break;
                    case 2:
                        System.out.println("You exit the dungeon, succesful from your         adventures!");
                        break;
                }
                if (choice == 2) {
                    break;
                }
            }
        }
        name = Player.name;
        System.out.println("\n##########################");
        System.out.println("# Thanks for playing " + name + "! #");
        System.out.println("##########################");
    }
}


class Player {

    Enemy Enemy = new Enemy();

    Scanner in = new Scanner(System.in);
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();
    String name;
    int hitPoints;
    int enemyDamageDealt = Enemy.enemyDamageDealt;
    int enemyHealth = Enemy.enemyHealth;
    int damageDealt;

    public void name() {

        System.out.println("Enter your username");
        this.name = sc.nextLine();
        System.out.println("You set your username to: " + name);

    }

    public void hitPoints() {
        hitPoints = rand.nextInt(500) + 5000;
    }

    public void attack() {

        damageDealt = rand.nextInt(100);
        enemyHealth -= damageDealt;
        hitPoints -= enemyDamageDealt;
        System.out.println("You damaged the enemy car for " + damageDealt);
        System.out.println("In return you got damaged for " + enemyDamageDealt);
    }
}


class Enemy {

    Scanner in = new Scanner(System.in);
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();

    int enemyDamageDealt = rand.nextInt(100);

    public String[] enemies = {"Skeleton", "Zombie", "Warrior", "Assassin", "Reaper", "Archer"};
    public String enemy = enemies[rand.nextInt(enemies.length)];


    int enemyHealth = rand.nextInt(500) + 250;

}