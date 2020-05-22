@Override
public boolean equals(Object obj) {
    if (obj instance of Piece) {
        Piece other = (Piece)obj;
        return other.position.equals(this.position);
    } else {
        return false;
    }
}