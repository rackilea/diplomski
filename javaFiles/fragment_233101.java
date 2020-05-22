private List<Predicate> getPredicates(CriteriaBuilder cb, Root<Flight> c, 
           Date departureDate) {

    List<Predicate> predicates = new ArrayList<>();

    //remove time portion from specified date: now dd/mm/yy 00:00
    Date startDate = DateUtils.truncate(departureDate, Calendar.DATE);

    //new date with time initialized to 23:59:59
    Date endDate = DateUtils.addSeconds(DateUtils.addDays(startDate, 1), - 1);

    predicates.add(cb.between(c.get(Flight_.departureDate), startDate, endDate));

    return predicates;
}