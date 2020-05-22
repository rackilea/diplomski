public static void main(String[] args) {
    Random dice = new Random();
    Scanner input = new Scanner(System.in);
    System.out.println("Do you want to roll the dice? (y: yes / q: to quit)");
    String answer = input.nextLine(); // reading the input

    // we check if the answer is equals to "y" to execute the loop,
    // if the answer is not equals to "y" the loop is not executed
    while ("y".equals(answer)) {  
        System.out.println("Dice Roller");
        System.out.println("How many faces does the dice have?");
        int faces = input.nextInt();
        int result = dice.nextInt(faces) + 1;
        input.nextLine(); // to read the newline character (*)
        System.out.println("The dice rolled a " + result);
        System.out.println("Do you want to roll the dice? (y: yes / q: to quit)");
        answer = input.nextLine();
    }
}