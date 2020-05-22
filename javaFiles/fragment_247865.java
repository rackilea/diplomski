int[][] scores = {{14, 21, 3, 7}, {0,0,0,0}};
    String teams[] = {"Ravens", "Steelers"};
    System.out.println("Game Summary");
    System.out.println("------------");

    for (int i = 0; i < scores.length; i++) {
        System.out.print(teams[i] +":");
        for (int j = 0; j < scores[i].length; j++) {
            System.out.printf("%3d", scores[i][j]);
        }
        System.out.println();
    }