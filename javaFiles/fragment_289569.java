public class TreeComparator implements Comparator<Tree> {
    @Override
    public int compare(Tree o1, Tree o2) {
        return Double.compare(o1.getSuitability(), o2.getSuitability());
    }
}