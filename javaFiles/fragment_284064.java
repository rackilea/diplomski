String[] myno1 = new String[]{"01", "02", "03", "04", "05", "06", "07", 
                              "08", "09", "10", "11", "12", "13", "14", "15"};
String[] myno2 = new String[]{"01", "03", "15"};

// use LinkedHashSet to preserve order
Set<String> set1 = new LinkedHashSet<>(Arrays.asList(myno1));
Set<String> set2 = new LinkedHashSet<>(Arrays.asList(myno2));

// find duplicates
Set<String> intersection = new LinkedHashSet<>();
intersection.addAll(set1);
intersection.retainAll(set2);

// remove duplicates from both sets
Set<String> result = new LinkedHashSet<>();
result.addAll(set1);
result.addAll(set2);
result.removeAll(intersection);

System.out.println("Result: " + result);