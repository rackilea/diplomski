public boolean isOverlapping(IntegerInterval other) {
    if (other == null) return false; // for readability's sake, this condition is pulled out

    // overlap happens ONLY when this's end is on the right of other's start
    // AND this's start is on the left of other's end.
    return (((this.end == null) || (other.start == null) || (this.end.intValue() >= other.start.intValue())) &&
        ((this.start == null) || (other.end == null) || (this.start.intValue() <= other.end.intValue())));
}