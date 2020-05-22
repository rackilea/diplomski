boolean flag = false;

do {
    try {
        int CmdMenuDecision = new Scanner(System.in).nextInt();
        flag = true; // If the execution flow reached this line then that means that the user input was correct; break the loop.
    }
    catch(InputMismatchException e) {
        System.out.println("Invalid input, try again.");
    }
}while(!flag);