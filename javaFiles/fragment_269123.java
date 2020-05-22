int index = 0;

public void rotateRight() {
    index = (index + 1) % cardinal.size();
    this.heading = cardinal.get(index);
}

public void rotateLeft() {
    index = (index - 1 + cardinal.size()) % cardinal.size();
    this.heading = cardinal.get(index);
}