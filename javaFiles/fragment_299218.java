while (true) {
    String name = scan.nextLine();
    if (name.startsWith("Ms. ") || name.startsWith("Mr. ")) {
        System.out.println("Welcome : " + name);
        break;
    } else {
        System.out.println("Please re-enter your name");
    }
}