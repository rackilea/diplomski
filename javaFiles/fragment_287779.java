private List<String> conflictList = new ArrayList<String>();

private final Map<String, Column> map = new HashMap<>();
for (Column c1: list1) map.put(c1.name, c1);
for (Column c2: list2) {
    Column c1 = map.put(c2.name, c2);
    if (c1==null) continue;
    if (c1.type.equals(c2.type)) continue;
    conflictList.add(c1); // or add the name only or both elements or whatever
}