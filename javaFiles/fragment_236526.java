char mi;
    Scanner sc = new Scanner(System.in);
    double total = 0.0;
    do {
        System.out.println("do you want to buy drinks?");
        System.out.println("1. A (500)");
        System.out.println("2. B (1000)");
        System.out.println("3. C (1500)");
        System.out.println("0 to not choose");
        System.out.println("Please choose you drink");
        //p.SetDrink(sc.nextDouble()); // not working unknown p in OP, so commented
        char drink = sc.next().charAt(0);
        System.out.println(drink); // just printing user's choice for drink
        switch (drink) {
                case 'A':
                    total += 500;
                    break;
                case 'B':
                    total += 1000;
                    break;
                case 'C':
                    total += 1500;
                    break;
                default:
                    total += 0;
            }

        System.out.println("do you want to buy more?");

        mi = sc.next().charAt(0);
    } while (mi=='y');
    System.out.println("total : " + total);