Scanner input = new Scanner(System.in);

    System.out.println("Do you want to calculate something? If no, type in 'quit'. If yes, simply type in 'yes'. ");
    String Continue = input.nextLine();
    if (Continue.equals("quit")) {
        System.out.println("Have a nice day! ");
    } else if (Continue.equals("yes")) {


        System.out.println(
                "Please input a fraction, there must be exactly one space between the operator and the operand. ");
        String readInput = input.nextLine();
        System.out.println(produceAnswer(readInput));
    }