@Override
public boolean equals(Object object) {
  if ( object == this ) {
    return true; // instance equality
  }
  if ( object == null || object.getClass() != getClass() ) {
    return false; 
  }
  final Price other = Price.class.cast( object );
  if ( getId() == null && other.getId() == null ) {
    // perform equality check against all non-id attributes
  }
  else {
    // perform equality check only on id
  }
}

@Override
public int hashCode() {
  final HashCodeBuilder hcb = new HashCodeBuilder( 17, 37 );
  if ( id == null ) {
     hcb.append( price );
     hcb.append( discount );
     // other fields
  }
  else {
    // only identity basis
    hcb.append( id );
  }
  return hcb.toHashCode();
}