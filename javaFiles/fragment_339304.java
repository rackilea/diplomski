@Override
public int compareTo(Object o) {

    try {
        return getLength().compareTo(((GraphEdge)obj).getLength()));
    } catch (Exception e) {
        throw new RuntimeException(e.getMessage(), e);
    }
    return 0;
}