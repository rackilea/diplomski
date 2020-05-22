String[] precincts = {"Precinct A", "Precinct B", "Precinct C", "Precinct D"};
int[] candidate_1_Votes = new int[precincts.length];
int[] candidate_2_Votes = new int[precincts.length];
int candidate1VoteSum = 0;
int candidate2VoteSum = 0;

// Getting User input with regards to voting results...
for (int i = 0; i < precincts.length; i++) {
    System.out.println("\nHow many votes were received in: " + precincts[i] + "?");
    System.out.print("For Candidate 1: ");
    candidate_1_Votes[i] = scnr.nextInt();
    candidate1VoteSum += candidate_1_Votes[i];

    System.out.print("For Candidate 2: ");
    candidate_2_Votes[i] = scnr.nextInt();
    candidate2VoteSum += candidate_2_Votes[i];
}