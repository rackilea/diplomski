public List<Place> findPlaces(String name, String streetname){
    Criteria crit = getSession().createCriteria(Place.class, "place");
    criteria.createAlias("streets", "s");  // Create alias for streets
    crit.add(Restrictions.like("s.name", name+"%"));
    // continue method
}