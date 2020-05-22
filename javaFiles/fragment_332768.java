@Override
public int hashCode() {
    return 31*31*Double.hashCode(x)
          +   31*Double.hashCode(y)
          +      Double.hashCode(z);
}