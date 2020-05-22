@Override
public boolean equals(Object that) {
    if(that == null || !(that instanceof Item))
        return false;
    return this.name.equals(that.name) && this.quantity == that.quantity;
}