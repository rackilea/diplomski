public void setMemory(ArrayList<Integer> memory) {
    this.memory = Optional.ofNullable(memory)
                          .map(ArrayList::new)
                          .filter(list -> ! list.contains(null))
                          .orElseThrow(() -> new IllegalArgumentException("memory is or contains null"));
}