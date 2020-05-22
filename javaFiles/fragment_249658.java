public int compareTo(ITSVehicle v) {
  result = this.getCapacity(0).compareTo(v.getCapacity(0));
  if( result == 0 ) {
    result = this.getCapacity(1).compareTo(v.getCapacity(1));
  }
  if( result == 0 ) {
    result = this.getCapacity(2).compareTo(v.getCapacity(2));
  }

  return result;
}