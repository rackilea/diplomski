@Override
public String toString() {
    StringBuilder builder = new StringBuilder(integer.length);
    for(int digit : integer) {
        builder.append(digit);
    }
    return builder.toString();
}