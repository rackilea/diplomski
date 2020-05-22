public boolean equals(Object obj) {
    if (!(obj instanceof Pair))
        return false;
    Pair that = (Pair)obj;
    boolean result = true;
    if (this.getValue1() != null)
        result = this.getValue1().equals(that.getValue1());
    else if (that.getValue1() != null)
        result = that.getValue1().equals(this.getValue1());

    if (this.getValue2() != null)
        result = result && this.getValue2().equals(that.getValue2());
    else if (that.getValue2() != null)
        result = result && that.getValue2().equals(this.getValue2());

    return result;
} 


public int hashCode() {
    int result = value1 != null ? value1.hashCode() : 0;
    result = 31 * result + (value2 != null ? value2.hashCode() : 0);
    return result;
}