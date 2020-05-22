boolean flag = true;

do {
    String name = scan.nextLine();
    if (name.startsWith("Ms. ") || name.startsWith("Mr. ")) {
        System.out.println("Welcome : " + name);
        // break the loop.
        flag = false;
    } else {
        System.out.println("Please re-enter your name");
    } 
} while (flag);