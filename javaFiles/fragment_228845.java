public boolean quantityEqualWith (Point other)    {
    if(this.quantity == other.quantity) return true;
    return false;
}
public boolean priceEqualWith (Point other)    {
    if (Math.abs(this.price - other.price)<TOLERANCE) return true;
    return false;
}

public boolean isEqual(Point other)    {
    if(this.priceEqualWith(other)&&this.quantityEqualWith(other)) return true;
    return false;
}
public boolean isQuantityEqual (Point other)    {
    if((!this.priceEqualWith(other))&&(this.quantityEqualWith(other))) return true;
    return false;
}
public boolean isPriceEqual (Point other)    {
    if((this.priceEqualWith(other))&&(!this.quantityEqualWith(other))) return true;
    return false;
}
public boolean isNotEqual(Point other)    {
    if((!this.priceEqualWith(other))&&(!this.quantityEqualWith(other))) return true;
    return false;
}