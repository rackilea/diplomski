@Override
public String toString() {
    StringJoiner joiner = new StringJoiner(", ", "[", "]");
    for (int i = 0; i < this.size; i++)
        joiner.add(String.valueOf(this.data[i]));
    return joiner.toString();
}