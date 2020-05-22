@Override
public int hashCode() {
    int result;
    long temp;
    result = title.hashCode();
    result = 31 * result + author.hashCode();
    temp = Double.doubleToLongBits(price);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    return result;
}