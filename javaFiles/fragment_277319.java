@Override
@Override
public boolean equals(Object other){
    if(other==null) return false;
    if (other == this) return true;
    return ((SomeClass)other).name.equalsIgnoreCase(this.name)
           && ((SomeClass)other).rank.equalsIgnoreCase(this.rank);
}

@Override
public int hashCode() {
   return Objects.hash(name, rank);
}