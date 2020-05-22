@Override
public int hashCode() {
    return 31*31*Double.valueOf(x).hashCode()
          +   31*Double.valueOf(y).hashCode()
          +      Double.valueOf(z).hashCode();
}
@Override
public boolean equals(Object other) {
    if (!(other instanceof Node)) {
        return false;
    }
    Node n = (Node)other;
    return x == n.x && y == n.y && z == n.z;
}