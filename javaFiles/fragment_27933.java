String studentName = "";
    int score1, score2, score3;
    float Average = 0f;
    int numberTests = 0;
    Scanner scr = new Scanner(System.in);

    System.out.println("Enter students name");
    String name = scr.nextLine();
    if (name.equalsIgnoreCase("quit"))
    {
        System.exit(0);
    }

    System.out.println("Enter the amount of tests");
    numberTests = scr.nextInt();
    System.out.println("Enter students scores");
    score1 = scr.nextInt();
    score2 = scr.nextInt();
    score3 = scr.nextInt();

    Average = (score1 + score2 + score3) / numberTests;
    System.out.print(studentName + " " + Average);
}