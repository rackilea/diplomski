@Override
public int compare(String[] lhs, String[] rhs) {
    int leftInt = Integer.parseInt(lhs[0]);
    int rightInt = Integer.parseInt(rhs[0]);
    return leftInt < rightInt ? -1
        : leftInt > rightInt ? 1
        : 0;
}