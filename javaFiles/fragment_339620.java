int numPlayers = 14;
 int [] cardPlayer = new int[numPlayers];
 int [] cardComputer = new int[numPlayers];

 for (int i = 0; i < numPlayers; i++) {         
            System.out.println("Player Card " + i + ": " + cardPlayer[i]);
            cardComputer[i] = rn.nextInt(7) + 1;
            System.out.println("Computer Card " + "i" + cardComputer[i]);
            System.out.println("");
}