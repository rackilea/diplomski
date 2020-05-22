public void selectMenu() throws InputMismatchException {
    int selectedMenu;
    Scanner aScanner = new Scanner(System.in);
    do {
        try {
            System.out.println("Try block begin.");
            selectedMenu = aScanner.nextInt();
            if(selectedMenu < 1 || selectedMenu > 4) {
                System.out.println("Input out of range \"" + selectedMenu + "\". Input..");
            }
        } catch(InputMismatchException e) {
            System.out.println("Catch blok begin.");
            System.out.println("Invalid input, please input a number between 1-4.");
            aScanner.nextLine();
            selectedMenu = 0;
        } 

    } while(selectedMenu < 1 || selectedMenu > 4);

    System.out.println("A new game will now start.");
}