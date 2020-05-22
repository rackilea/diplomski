public class Group implements Comparable{
    private int difference;
    ... //code

    public int compareTo(Group g) {
        int diff = g.getDiff();
        if(diff > this.difference) { // compared Group obj has greater diff
            return -1;
        }else if(diff == this.difference) { // compared Group obj has equal diff
            return 0;
        }else { // compared Group obj has lesser difference
            return 1;
        }
    }
}