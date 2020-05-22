int bet = input.nextInt();

//add nextLine() to consume newline character
input.nextLine();

while (bet > 25 || bet < 5 || bet % 5 != 0 || bet > bank) {
    System.out
            .print("Please re-enter you bet, this must be either 5, 10, 15, 20 or 25\nand be less than €"
                    + bank + ": ");

    bet = input.nextInt();

    //add nextLine() to consume newline character
    input.nextLine();
}