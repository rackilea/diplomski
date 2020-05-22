public class UsernameScorePairComparator {

    public UsernameScorePairComparator() {
    }

    public int compare(Object o1, Object o2) {
        UsernameScorePair usp1 = (UsernameScorePair)o1;
        UsernameScorePair usp2 = (UsernameScorePair)o2;

        return usp1.getScore() - usp2.getScore();
    }
}