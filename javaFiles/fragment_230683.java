public static void printResults(Candidate[] election)
 {
   double percent;
   int getTotalVotes = getTotal(election); //To calculate this once, it saves you execution time, with large numbers

   System.out.println("Candidate        Votes Received      % of Total Votes");

   for (Candidate candidate : election)
   {
      percent = (double) (candidate.votes()) / getTotalVotes * 100;
      System.out.printf("%-15s %10d %20.0f", candidate.getName(), candidate.votes(), percent);
      System.out.println();
   }
 }