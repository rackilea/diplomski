List<Map.Entry<Project, List<Activity>> l = new ArrayList<>(myMap.entrySet());
 Collections.sort(l, new Comparator<Map.Entry<Project, List<Activity>>() {
   public int compare( Map.Entry<Project, List<Activity> lhs, Map.Entry<Project, List<Activity> rhs) {
    return lhs.getKey().unit.unitName.compareTo(rhs.getKey().unit.unitName);
  }
 });