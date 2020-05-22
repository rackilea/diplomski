@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    long temp;
    temp = Double.doubleToLongBits(this.totalIncome);
    result = (prime * result) + (int) (temp ^ (temp >>> 32));
    return result;
}

@Override
public boolean equals(final Object obj) {
    if (this == obj) {
        return true;
    }
    if (obj == null) {
        return false;
    }
    if (getClass() != obj.getClass()) {
        return false;
    }
    final GirlScoutCheck other = (GirlScoutCheck) obj;
    if (Double.doubleToLongBits(this.totalIncome) != Double.doubleToLongBits(other.totalIncome)) {
        return false;
    }
    return true;
}