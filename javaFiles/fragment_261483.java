public static void main(String[] args) {

    List<List<String>> list1 = Arrays.asList(
            Arrays.asList("Tom", "Hardy", "nineteen", "student"),
            Arrays.asList("John", "Travolta", "twenty", "unemployed"));

    List<List<String>> list2 = Arrays.asList(
            Arrays.asList("Tom", "Hardy", "nineteen", "student"),
            Arrays.asList("John", "Travolta", "twenty", "unemployed"));

    List<String> thesePeople = separatePropertiesToBigSinglePropertySortedList(list1);
    List<String> thosePeople = separatePropertiesToBigSinglePropertySortedList(list2);
    System.out.println("sortedListsAreEqual = " + thesePeople.equals(thosePeople));
}

private static List<String> separatePropertiesToBigSinglePropertySortedList(List<List<String>> listWithSeparateProperties) {
    List<String> resultList = new ArrayList<String>();
    for (List<String> propertiesOfPerson : listWithSeparateProperties) {
        String bigSingleProperty = "";
        for (String property : propertiesOfPerson) {
            bigSingleProperty = bigSingleProperty + property;
        }
        resultList.add(bigSingleProperty);
    }
    Collections.sort(resultList);
    return resultList;
}