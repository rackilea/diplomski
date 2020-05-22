List<CustomType> customList = new ArrayList<CustomType>() {
    @Override
    public int indexOf(Object o) {
        if (o instanceof CustomType) {
            for (int i = 0; i < this.size(); i++) {
                CustomType c = (CustomType) o;
                if (c.isEquivalent(this.get(i))) {
                    return i;
                }
            }
        }
        return -1;
    }
};
// use indexOf like normal, but beware of side-effects as mentioned in the comments