int i = 100;
boolean status = true;
Scanner sc = new Scanner(System.in);

do {
    try {
        System.out.print("Type a number: ");
        int powerNumber = Integer.parseInt(sc.nextLine());
        System.out.println(i * powerNumber);
    } catch (NumberFormatException exc) {
        exc.printStackTrace();
        status = false;
    }
} while (status);