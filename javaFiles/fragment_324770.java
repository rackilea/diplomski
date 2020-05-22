// assumes you "import java.util.Scanner"
Scanner sc = new Scanner(System.in);
while(sc.hasNextLine()) {
    String line = sc.nextLine();
    System.out.println("You typed: " + line);
}