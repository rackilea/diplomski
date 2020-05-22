public class BuddyScore {
    private Buddy buddyScore;

    public BuddyScore(Buddy buddyScore) {
        this.buddyScore = buddyScore;      // here you store the 'reference' of your Buddy object
    }

    public int getFinalScore() {
        return finalScore += buddyScore.getBuddyScore();  // here you retrieve the most recent 'buddyScore' from your 'Buddy' object and add it to the finalScore
    } 
}