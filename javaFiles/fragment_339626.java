public class YComparator implements Comparator<Y>, Serializable {
    private XComparator xComparator = new XComparator();

    @Override
    public int compare(Y y1, Y y2) {
         // compare y1.booleanData with y2.booleanData
         if (...)
             ...;

         // else otherwise:
         return xComparator.compare(y1, y2);
    }
}