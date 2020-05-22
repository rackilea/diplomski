for (int i = 1; i <= numGames; i = i + 1) {

            for (int j = 1; j<= gameType; j = j + 1) {
                int ranNums = randomGenerator.nextInt(9);
                System.out.print(ranNums + " ");
            }
            System.out.println();
        }