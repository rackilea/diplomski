public int start(int group) {
    if (first < 0)
        throw new IllegalStateException("No match available");
    if (group < 0 || group > groupCount())
        throw new IndexOutOfBoundsException("No group " + group);
    return groups[group * 2];
}