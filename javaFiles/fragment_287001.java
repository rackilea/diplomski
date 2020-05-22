public Set<String> getHoursAvailable(int vetId, String date){
    List<Visit> visitList = getVisitByVetIdAndDate(vetId,date);
    Set<String> hoursAvailable = new LinkedHashSet<>(
          Arrays.asList(VisitTime.getVisittime()));

    visitList.stream()
       .map(Visit::getTime)
       .map(Time::toString)
       .forEach(vt-> hoursAvailable.removeIf(s->s.equals(vt)));

    return hoursAvailable;
}