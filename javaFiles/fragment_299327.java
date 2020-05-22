public class IndexPairComparator extends WritableComparator {
protected IndexPairComparator() {
    super(IndexPair.class);
}

@Override
public int compare(byte[] b1, int s1, int l1, byte[] b2, int s2, int l2) {
    int i1 = readInt(b1, s1);
    int i2 = readInt(b2, s2);

    int comp = (i1 < i2) ? -1 : (i1 == i2) ? 0 : 1;
    if(0 != comp)
        return comp;

    int j1 = readInt(b1, s1+4);
    int j2 = readInt(b2, s2+4);
    comp = (j1 < j2) ? -1 : (j1 == j2) ? 0 : 1;

    return comp;
}