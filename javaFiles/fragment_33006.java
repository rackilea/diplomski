boolean check = false;
do {
    String txt = math.nextLine();
    switch (txt) {
        case "add":
            System.out.println("You selected ADDITION");
            System.out.println("Enter first number");
            fnum = math.nextDouble();
            System.out.println("Enter second number");
            snum = math.nextDouble();
            answer = fnum + snum;
            System.out.println(answer);
            check = true;//change your boolean to true
            break;
        case "sub":
            System.out.println("You selected SUBTRACTION");
            System.out.println("Enter first number");
            fnum = math.nextDouble();
            System.out.println("Enter second number");
            snum = math.nextDouble();
            answer = fnum - snum;
            System.out.println(answer);
            check = true;//change your boolean to true
            break;
        case "mul":
            System.out.println("You selected MULTIPLICATION");
            System.out.println("Enter first number");
            fnum = math.nextDouble();
            System.out.println("Enter second number");
            snum = math.nextDouble();
            answer = fnum * snum;
            System.out.println(answer);
            check = true;//change your boolean to true
            break;
        case "div":
            System.out.println("You selected DIVISION");
            System.out.println("Enter first number");
            fnum = math.nextDouble();
            System.out.println("Enter second number");
            snum = math.nextDouble();
            answer = fnum / snum;
            System.out.println(answer);
            check = true;//change your boolean to true
            break;
        default:
            System.err.println("Please enter a valid option");
    }
} while (!check);