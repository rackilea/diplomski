System.out.println("Enter level");

    Scanner scan=new Scanner(System.in);

    int level=getSafeInteger();
    while (level > 3 || level < 0){
        System.out.println("Please enter a valid level!: ");
        level = getSafeInteger();
    }