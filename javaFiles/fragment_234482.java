public static List<Person> maxSubSetWithGreaterAverage(Collection<Person> persons,
        int averageLimit) {
    List<Person> list = new ArrayList<>(persons);
    list.sort(Comparator.comparingInt(Person::getAge).reversed());
    int cumulativeAge = 0;
    for(int i=0; i<list.size(); i++) {
        cumulativeAge += list.get(i).getAge();
        if(cumulativeAge <= averageLimit * (i + 1) )
            return list.subList(0, i);
    }
    return list;
}