public void setMemory(ArrayList<Integer> memory) {
    if (memory == null)
        throw new IllegalArgumentException("memory is null");

    List<Integer> temp = new ArrayList<>(memory);

    if (temp.contains(null))
        throw new IllegalArgumentException("memory contains null");

    this.memory = temp;
}