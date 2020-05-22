public class VoteEntry {

    // candidate INDEX
    private final IntegerProperty candidate;

    private final IntegerProperty voteCount;

    public VoteEntry(int candidate, int count) {
        this.voteCount = new SimpleIntegerProperty(count);
        this.candidate = new SimpleIntegerProperty(candidate);
    }

    public final int getCandidate() {
        return this.candidate.get();
    }

    public final void setCandidate(int value) {
        this.candidate.set(value);
    }

    public final IntegerProperty candidateProperty() {
        return this.candidate;
    }

    public final int getVoteCount() {
        return this.voteCount.get();
    }

    public final void setVoteCount(int value) {
        this.voteCount.set(value);
    }

    public final IntegerProperty voteCountProperty() {
        return this.voteCount;
    }

}