@Override
public String toString() {
    StringBuilder buf = new StringBuilder().append('[');
    for (int i = 0; i < this.size; i++) {
        if (i != 0) buf.append(", ");
        buf.append(this.data[i]);
    }
    return buf.append(']').toString();
}