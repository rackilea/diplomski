// in Point class
@Override
public boolean equals(Object other) {
    if (other == null || getClass() != other.getClass()) {
         return false;
    }
    Point p = (Point) other;
    return p.x == x && p.y == y;
}