public void countVotes(String[] votes) {
    do {

        singleVote = JOptionPane.showInputDialog("Voting system. Please, enter:\nA - To vote for candidate A.\nB - To vote for candidate B.\n"
                + "Z - To finish the voting process.\nAnything else will be considered as an INVALID vote.");

        switch (votes[0]) {
            case "A":
                aCount = aCount + 1;
                break;
            case "B":
                bCount = bCount + 1;
                break;
            default:
                invalidCount = invalidCount + 1;
        }
    } while (singleVote != "Z" || (aCount + bCount + invalidCount) <= v_numVoters);
}

public static void main(String[] args) {

    Votes newVotes = new Votes();
    newVotes.m_numVoters();
    newVotes.countVotes(args);
    System.out.println(aCount + " " + bCount + " " + invalidCount);
}