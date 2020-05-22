@Override
public int compareTo(LocalTime other) {
    int cmp = Integer.compare(hour, other.hour);
    if (cmp == 0) {
        cmp = Integer.compare(minute, other.minute);
        if (cmp == 0) {
            cmp = Integer.compare(second, other.second);
            if (cmp == 0) {
                cmp = Integer.compare(nano, other.nano);
            }
        }
    }
    return cmp;
}