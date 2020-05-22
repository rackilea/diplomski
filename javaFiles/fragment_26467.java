public void setMemory(ArrayList<Integer> memory) {
    List<Integer> temp;
    if (memory == null || ((temp = new ArrayList<>(memory)).contains(null)))
        throw new IllegalArgumentException("memory is or contains null");
    this.memory = temp;
}