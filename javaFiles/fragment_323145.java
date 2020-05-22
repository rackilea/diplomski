@Override
public int hashCode() {
    int hashValue = 11;
    hashValue = 31 * hashValue + x;
    hashValue = 31 * hashValue + y;
    return hashValue;
    }

@Override
public String toString() {
    return "Point[" + X + ", " + Y + "]";
}