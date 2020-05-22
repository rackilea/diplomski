public List<Bar> getBars() {
    return Collections.unmodifiableList(this.bars);
}

public void addBar(Bar b) {
    this.bars.add(b);
    this.modifiedDate = new Date(0L);
}

...