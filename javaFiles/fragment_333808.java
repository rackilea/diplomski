Scanner sc = new Scanner(System. in ); //scanner object created

while (true) {
    System.out.println("Enter your first number");
    int nr1 = Integer.parseInt(sc.nextLine());
    System.out.println("Enter your second number");
    int nr2 = Integer.parseInt(sc.nextLine());
    System.out.println("Enter your sign (+ , - , /, *)");
    String anvin = sc.nextLine();
    int ans = 0;
    //somewhere around this line is where it is having the problems. it gives me the answer before i can put in my sign;
    if (anvin.equalsIgnoreCase("+")) {
        ans = nr1 + nr2;
    } else if (anvin.equalsIgnoreCase("-")) {
        ans = nr1 - nr2;
    } else if (anvin.equalsIgnoreCase("*")) {
        ans = nr1 * nr2;
    } else if (anvin.equalsIgnoreCase("/")) {
        ans = nr1 / nr2;
    }

    System.out.println(ans);
    System.out.println("To continue type yes");
    String yes = sc.nextLine();

    if (!yes.equalsIgnoreCase("yes")) {
        break;
    }
}