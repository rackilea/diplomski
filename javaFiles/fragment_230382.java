@Override
public int compareTo(NavLocation other) {
    int result = getPage().compareTo(other.getPage());
    if (result != 0) {
        return result;
    }

    return getSection().compareTo(other.getSection());
}