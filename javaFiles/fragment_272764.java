public class Application {

    public static void main(String[] args) {
        char redo;
        do {
            System.out.println("What is the command keyword to exit a loop in Java?\na. int\nb. continue\nc. break\nd. exit\nEnter your choice");
            Scanner scanner = new Scanner(System.in);
            char ans = scanner.next().charAt(0);
            if (ans == 'c') {
                System.out.println("Correct");
                break;
            }
            else {
                System.out.println("Wrong! Presss Y to try again.");
                redo = scanner.next().charAt(0);
            }
        }
        while (redo == 'y');
    }

}