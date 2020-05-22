public int compareTo(Object o) {
    PlayingCard other = (PlayingCard) o;
    int result = this.suit - other.suit;
    if (result != 0) 
        return result;
    return this.rank - other.rank;
}