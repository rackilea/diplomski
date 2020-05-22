@Override
public boolean equals(Object other) {
    return (id != null && other != null && getClass() == other.getClass())
         ? id.equals(((Matches) other).id)
         : (other == this);
}

@Override
public int hashCode() {
    return (id != null) 
         ? (getClass().hashCode() + id.hashCode()) 
         : super.hashCode();
}