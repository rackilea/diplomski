@Override
public boolean equals(Object obj) {
    if (obj == null || getClass() != obj.getClass()) {
        return false;
    }

    final Car other = (Car) obj;
    return (this.cash == other.cash && this.brand.equals(other.brand));
}