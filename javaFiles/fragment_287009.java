public static void main(String [] args) {
    Scanner key;
    String moves;
    int count = 0;
    String pass = "hey";
    while(true) {
        System.out.println("Enter password: ");
        key = new Scanner(System.in);
        moves = key.nextLine();
        if(moves.compareTo(pass) == 0){
            count++;
            System.out.println("You're one step closer to a free coffe! You have so far bought " + count + " coffe(s)");
        }
        if(count % 10 == 0 && count != 0){
            System.out.println("You've got a free coffe!");
        }
        if(moves.compareTo(pass) != 0){
            System.out.println("Wrong password! Try again.\n");
        }
    }
}