public void addElements() throws Exception {
    int lastCap = -1;
    for (int j = 0; j < 1000000; j++) {
        this.normalList.add(j);
        int cap = getCapacity(this.normalList);
        if (cap != lastCap) {
            System.out.println("size:" + normalList.size() + " capacity:" + cap);
            lastCap = cap;
        }
    }
}

int getCapacity(List al) throws Exception {
    Field field = ArrayList.class.getDeclaredField("elementData");
    field.setAccessible(true);
    return ((Object[]) field.get(al)).length;
}