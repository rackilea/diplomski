int x = 0;
    int y = 0;
    int index = 0;
    boolean flag = true;
    Scanner scanner = new Scanner(System.in);

    while(flag) {
        try {
            System.out.println("Type the first nubmer: ");
            x = scanner.nextInt();
            flag = false;
        }catch (Exception e) {
            System.out.println("Type a proper number you idiot!");
            scanner.nextLine();
        }

    }
    flag = true;

    while(flag) {
        try {
            System.out.println("Type the second nubmer: ");
            y = scanner.nextInt();
            if(y == 0) {
                System.out.println("Can't divide by 0!");
                continue;
            }
            flag = false;
        }catch (Exception e) {
            System.out.println("Type a proper number you idiot!");
            scanner.nextLine();
        }
    }
    System.out.println("The result is: " + x/y);