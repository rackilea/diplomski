Scanner input = new Scanner(System.in);

        System.out.print("Give me number 1: ");
        int n1 = input.nextInt();

        System.out.print("Give me number 2: ");
        int n2 = input.nextInt();

        System.out.print("Give me an operator: ");
        String o = input.next();

        switch (o) {
        case "+":   
            System.out.println(n1 + n2);
            break;
        case "-":   
            System.out.println(n1 - n2);
            break;
        case "*":   
            System.out.println(n1 * n2);
            break;
        case "/":   
            System.out.println(n1 / n2);
            break;

        default:
            System.out.println("Error, invalid operand.");