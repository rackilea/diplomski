public SortedMap<Integer, Long> countingByAge(){
    return  students.entrySet()
            .stream()
            .map(Map.Entry::getValue)
            .collect(groupingBy(Student::getAge, TreeMap::new, counting()));
}