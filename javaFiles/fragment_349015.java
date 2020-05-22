@Override
public int compare(Type i1, Type i2) {
    int res = i1.state - i2.state;
    if (res == 0) {
        return i1.name.compareTo(i2.name);
    } else {
        return res;
    }
}