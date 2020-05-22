@Override
public int compareTo(Songs o) {

    int compare;
    if ((compare = this.getSinger().compareTo(o.getSinger())) != 0) {
        return compare;
    } else if ((compare = this.getTitle().compareTo(o.getTitle())) != 0) {
        return compare;
    }
    return this.getYear() - o.getYear();
}