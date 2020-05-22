public class Main {
    public static void main(String [] args) {

        // create an instance of Display class
        Display d = new Display();

        // get the needed values to pass to printGreeting method:
        String[] clubs = {"club one", "club two" // put 20 clubs

        // get the index from the user
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number 1: ");
        while (!sc.hasNextInt()) sc.next();
        int choice = sc.nextInt();

        // call the method and get the return:
        String result = d.printGreeting(choice, clubs)

        // then get a serializer and execute method:
        Serialize s = new Serialize();
        s.serialize(result);
    }  
}