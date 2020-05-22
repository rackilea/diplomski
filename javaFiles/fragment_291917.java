Set<Integer> toRemoveSet = new HashSet<>(toRemove);
List<String> cleanList = new ArrayList<>();
for(int i = 0; i < myList.size(); i++) {
  if(!toRemoveSet.contains(i)) {
    cleanList.add(myList.get(i));
  }
}
System.out.println(cleanList);