Scanner sc = new Scanner(System.in);
System.out.println("Continue?[Y/N]");
while (sc.hasNext() && (sc.nextLine().equalsIgnoreCase("y"))) {//change here
    System.out.println("Enter first name");
    String name = sc.nextLine();
    System.out.println("Enter surname");
    String surname = sc.nextLine();
    System.out.println("Enter number");
    int number = 0;
    try {
        number = Integer.parseInt(sc.nextLine());
    } catch (IllegalArgumentException e) {
        e.printStackTrace();
    }
    System.out.println("Continue?[Y/N]");
}