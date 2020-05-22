public Fraction(int n, int d) {
    num = n; 
    denom = d; 
}

public Fraction(Fraction other) {
    this(other.num, other.denom);
}