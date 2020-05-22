public ArrayList<Measure> filter(Predicate<Measure> predicate) {
    ArrayList<Measures> filteredMeasures = new ArrayList();
    for (Measure measure : allMeasures)
        if (predicate.test(measure))
            filteredMeasures.add(measure);
    return filteredMeasures;
}