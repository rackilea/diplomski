System.out.println("Please enter a number");
Scanner choice1 = new Scanner(System.in);
int choiceH = -1; // some default value

while (!choice1.hasNextInt()) {
    System.out.println("Please enter a number");
    choice1.nextInt();
}