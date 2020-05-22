public class Triangle extends Shape {
    // The normal triangle stuff

    @Override
    public int hashCode() {
        int ret = getA();
        ret *= 31;
        ret += getB();
        ret *= 31;
        ret += getC();
        return ret;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Triangle other = (Triangle) obj;

        return getA() == other.getA() &&
               getB() == other.getB() &&
               getC() == other.getC();
    }
}