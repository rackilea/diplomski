List<List<String>> listList = new ArrayList<>();

List<String> listOne = Arrays.asList("A", "B", "C", "D");
List<String> listTwo = Arrays.asList("D", "D", "D", "B");

listList.add(listOne);
listList.add(listTwo);

Map<String, Integer> map = new HashMap<>();
    map.put("A", 1);
    map.put("B", 2);
    map.put("C", 1);
    map.put("D", 4);


listList.forEach(list -> list.sort(Comparator.comparingInt(map::get)));