@Override
public boolean equals(Object o) {
    if (o instanceof B) {
        B b = (B)o;
        return b.id == this.id;
    }
    return false;
}