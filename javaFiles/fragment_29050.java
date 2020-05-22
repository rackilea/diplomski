public int compare( Project lhs, Project rhs) {
  //as above null checks etc. are omitted for simplicity's sake
  int r = lhs.unit.unitName.compareTo(rhs.unit.unitName);
  if( r == 0 && !lhs.equals(rhs)) {
    r = lhs.projectName.compareTo( rhs.projectName );

    //you could also use the natural ordering of the projects here:
    //r = lhs.compareTo( rhs );
  }
  return r;
}