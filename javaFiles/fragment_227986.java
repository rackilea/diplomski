@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Cell)) return false;

    Cell cell = (Cell) o;

    if (x != cell.x) return false;
    return y == cell.y;

}

@Override
public int hashCode() {
    int result = x;
    result = 31 * result + y;
    return result;
}