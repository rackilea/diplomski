while (userChoices[num - 1] == 1)
{
    try {
        System.out.print("Enter your menu choice:  ");
        num = kb.nextInt();
        kb.nextLine();
    } catch (InputMismatchException e) {
        System.out.println("Error. Invalid input. Try again."); // Or whatever error message you want.
    }
}