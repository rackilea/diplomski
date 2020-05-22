@Override
public int compareTo(Wonder other) {
    if(this == other) {
        return 0;
    } else if(hostility < other.hostility) {
        return -1;
    } else if(hostility > other.hostility) {
        return 1;
    } else {
        return -countries.get(0).compareTo(other.countries.get(0));
    }
}