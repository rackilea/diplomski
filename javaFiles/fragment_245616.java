@Override
    public int hashCode() {
        HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
        hashCodeBuilder.append(x.doubleValue());
        hashCodeBuilder.append(y.doubleValue());
        return hashCodeBuilder.toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Point)) {
            return false;
        }
        Point other = (Point) obj;
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        equalsBuilder.append(x.doubleValue(), other.x.doubleValue());
        equalsBuilder.append(y.doubleValue(), other.y.doubleValue());
        return equalsBuilder.isEquals();
    }