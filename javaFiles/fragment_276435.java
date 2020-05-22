public static void drawRanks(String line, Graphics g){
    int yearIncrease = 0;
    System.out.println(line);
    Scanner lineScan = new Scanner(line);
    String name = lineScan.next();
    String gender = lineScan.next();
    int lastRank = lineScan.nextInt();
    int lastY = lastRank/2 + 25;
    if ( lastRank == 0 ) {
        lastY = 525;
    }
    int lastX = 0;

    while ( lineScan.hasNextInt() ) {
        int rank = lineScan.nextInt();

        int y = rank/2 + 25;
        if (rank == 0){
            y = 525;
        }
        int x = lastX + SECTION_WIDTH;

        String intervalLabel = name + " " + gender + " " + String.valueOf(lastRank);

        g.setColor(Color.RED);
        g.drawLine(lastX, lastY, x, y);
        g.drawString(intervalLabel,lastX,lastY);
        lastX = x;
        lastY = y;
        lastRank = rank;

    }

    g.drawString(intervalLabel,lastX,lastY);

    for(int j = 0; j < DECADES; j++) {
        g.setColor(Color.BLACK);
        g.drawString(String.valueOf(STARTING_YEAR + yearIncrease), SECTION_WIDTH * j, 550);
        yearIncrease += 10;
    }  

    for (int k = DECADES * SECTION_WIDTH; k >= 0; k -= SECTION_WIDTH){
        g.drawLine(k, 0, k, 550);
    }

}