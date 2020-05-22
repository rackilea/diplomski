public String group(int group) {
    if (first < 0)
        throw new IllegalStateException("No match found");
    if (group < 0 || group > groupCount())
        throw new IndexOutOfBoundsException("No group " + group);
    if ((groups[group*2] == -1) || (groups[group*2+1] == -1))
        return null;
    return getSubSequence(groups[group * 2], groups[group * 2 + 1]).toString();
}