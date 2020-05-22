int[] data = {0,1,2,4,8,16};
  int[] samples = new int[5];

  Random random = new Random();
  int value;
  int round = 3; // take in the number of rounds.
  int[] wins = {0,0,0,0,0}; // we'll use this to store the player # of wins.
  // Run the game for the specified number of rounds.
  for(int i = 0; i < round; i++){
    // Get 5 random numbers for each player.
    for(int j=0;j<5;j++){
        value = random.nextInt(6);
        samples[j] = data[value];
    }
    // Set the current winner to junk values.
    int max = Integer.MIN_VALUE;
    int winner = 0;
    // Run though the samples for the current round.
    for(int j = 0; j < samples.length; j++){
      // Print test of each players number.
      System.out.println("Player" + (j + 1) + " Score " + samples[j]);
      // Check in order which player won the round.
        if(samples[j] > max){
          max = samples[j];
          winner = j;
        }
    }
    // Increment the number of wins for the winner.
    wins[winner]++;
    System.out.println();
  }
  // Print test of round wins.
  for(int i = 0; i < wins.length; i++){
    System.out.println("Player" + (i+1) + " Wins " + wins[i]);
  }
}