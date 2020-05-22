public class Tree implements Comparable<Tree> {
    @Override
    public int compareTo(Tree o) {
        // use the value which should be used for comparison instead of getSuitability().
        // remember: here you have private access to object o. if your value is not a
        // double, there is also a Integer.compare(..) function, but you could also just
        // return value - other.value..
        return Double.compare(getSuitability(), o.getSuitability());
    }
    // .. code ..
}