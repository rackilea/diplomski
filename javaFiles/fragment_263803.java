private class EnumChildren implements Enumeration<Integer> {
    int category, current;
    int[] next, first;

    public EnumChildren(int category) {
        ChildrenArrays childrenArrays = tr.getChildrenArrays();
        first = childrenArrays.getYoungestChildArray(); 
        next = childrenArrays.getOlderSiblingArray();
        current = first[category];
    }

    public boolean hasChildren() {
        return (current != TaxonomyReader.INVALID_ORDINAL);
    }

    @Override
    public boolean hasMoreElements() {  
        current = next[current];
        return (current != TaxonomyReader.INVALID_ORDINAL);
    }

    @Override
    public Integer nextElement() {
        return current;
    }
}