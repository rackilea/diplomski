public static void main(String[] args) {
    Election election = new Election();

    addCandidates(election);

    countVotesFromFile(election, new File("votes"));

    System.out.println(election.reportResults());
}