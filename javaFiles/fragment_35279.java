int i = 0;
      while (i == 0) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter just int");
        if (input.hasNextInt()) {
            System.out.println(input.nextInt());
            System.out.println("good day");
            i = 1;
        } else {
            System.out.println("please enter type int");
        }
    }