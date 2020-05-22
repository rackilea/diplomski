public static void ask() {

 Scanner sc = new Scanner(System.in);
 boolean isWrongAnswer;
 do {
    isWrongAnswer = false;
    System.out.println("What do you want to do?");
    switch (sc.nextInt()) {
        case 1:
            eat();
            break;
        case 2:
            walk();
            break;
        case 3:
            sleep();
            break;
        default:
           System.out.println("choose from 1 to 3");
           isWrongAnswer = true;
        }
 } while (isWrongAnswer);
}