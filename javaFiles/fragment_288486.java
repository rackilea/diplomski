System.out.print("How many rows do you want in your Theatre");
    int r = input.nextInt(); input.nextLine();
    System.out.print("How many Columns do you want in your Theatre");
    int c = input.nextInt(); input.nextLine();
    System.out.printf("You want %d rows and %d columns in your Theatre", r, c);


    int [] [] seat = new int [r] [c];