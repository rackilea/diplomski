String[] precincts = {"Precinct A", "Precinct B", "Precinct C", "Precinct D"};
int candidate1VoteSum = 0;
int candidate2VoteSum = 0;

for (int i = 0; i < precincts.length; i++) {
    System.out.println("\nHow many votes were received in: " + precincts[i] + "?");
    System.out.print("For Candidate 1: ");
    candidate1VoteSum += scnr.nextInt();

    System.out.print("For Candidate 2: ");
    candidate2VoteSum += scnr.nextInt();
}