NewClass cal = new NewClass();
    Scanner in = new Scanner(System.in);
    System.out.println("Press 1 for Division.\nPress 2 for Multiplication.\nPress 3 for Addition.\nPress 4 for Substraction.");
    int c = in.nextInt();
    System.out.println("Enter First Value : ");
    int a = in.nextInt();
    System.out.println("Enter Second Value : ");
    int b = in.nextInt();
    switch (c){
        case 1:
            cal.division(a, b);
            break;
        case 2:
           cal.division(a, b);
            break;
        case 3:
            cal.add(a, b);
            break;
        case 4:
            cal.sub(a, b);
            break;
        default:
            System.out.println("Invalid entry.");
            break;
    }