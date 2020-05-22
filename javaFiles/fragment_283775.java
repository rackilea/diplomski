scan.close();
Scanner kbScan = new Scanner(System.in);
while(true){
    showBoard();
    System.out.println("");
    System.out.println("Input number from 1 to 5: ");
    //This will read from the keyboard
    int i = kbScan.nextInt();
    System.out.println("Input move command: ");
    String moveName = scan.next();