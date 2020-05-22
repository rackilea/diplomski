@Override
public boolean equals(Object o) {
    if (o instanceof Complex) {
        return this.im == ((Complex) o).im && this.re == ((Complex) o).re;
    } else {
        return super.equals(o);
    }
}