@Override
public int hashCode() {
    int hash = 7;
    hash = 71 * hash + this.x;
    hash = 71 * hash + this.y;
    return hash;
}



@Override
public boolean equals(Object other) 
{
    if (this == other)
       return true;

    if (!(other instanceof Point))
       return false;

    Point otherPoint = (Point) other;
    return otherPoint.x == x && otherPoint.y == y;
}