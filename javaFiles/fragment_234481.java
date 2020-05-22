public static List<Person> maxSubSetWithGreaterAverage(Collection<Person> persons,
        int averageLimit) {
    List<Person> list = new ArrayList<>(persons);
    // Sort people by age, decreasing
    list.sort(Comparator.comparingInt(Person::getAge).reversed());
    // get all the ages
    int[] ages = list.stream().mapToInt(Person::getAge).toArray();
    // transform them to cumulative sums
    Arrays.parallelPrefix(ages, Integer::sum);
    // Find the longest prefix for which the cumulative sum is bigger
    // than average
    int length = IntStream.range(0, ages.length)
            .filter(count -> ages[count] <= averageLimit * (count + 1)).findFirst()
            .orElse(ages.length);
    // return the corresponding subList
    return list.subList(0, length);
}