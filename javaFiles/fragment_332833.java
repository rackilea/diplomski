System.out.println("\nCandidate 1 recieved a total of " + 
        candidate1VoteSum + " votes from all Precincts.");
System.out.println("Candidate 2 recieved a total of " + 
        candidate2VoteSum + " votes from all Precincts.");

System.out.println("\nThe winning Candidate is: " + 
        // Nested Ternary Operators are used here.
        (candidate1VoteSum == candidate2VoteSum ? "It's A Tie!" : 
        (candidate1VoteSum > candidate2VoteSum ? "Candidate 1" : "Candidate 2"))
);