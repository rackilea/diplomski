SortedMap<Project, List<Activity>> myMap = new TreeMap<>( new Comparator<Project>() {
  public int compare( Project lhs, Project rhs) {

    int r = lhs.unit.unitName.compareTo(rhs.unit.unitName); //note that null checks etc. are omitted for simplicity, don't forget them in your code unless you know for sure that unit and unitName can't be null   
    if( r == 0 && !lhs.equals(rhs)) {
      //take other properties into account for consistent behavior with equals()
      //see "Update 2" below
    }
    return r;
  }
});