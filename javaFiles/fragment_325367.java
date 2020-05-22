public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in); // We'll ignore finer problems with scanners, etc. here
    playGame(scanner);

}

public static void playGame(Scanner scanner) {
    System.out.println("Guess the number of Apples Tom has");
    Scanner sc= new Scanner(System.in);
    int number=sc.nextInt();
    System.out.println("Tom, is it higher or lower?");
    String higherOrLower=sc.nextLine();

    while(true){
        number= getValue(higherOrLower,number);
        System.out.println("Tom, is it higher or lower?");
        higherOrLower=sc.nextLine();
        if(higherOrLower.equalsIgnoreCase("none")) {
            break;
        }
    }
}