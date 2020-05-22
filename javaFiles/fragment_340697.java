@Override
public int compare(Long o1, Long o2) {
    if (isLessThanUnsigned(o1, o2)) {
        return -1;
    } else if (o1.equals(o2)) {
        return 0;
    } else {
        return 1; // <<== HERE: 1, not -1
    }
}