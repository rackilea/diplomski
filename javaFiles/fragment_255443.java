Set<String> firstSet = new HashSet<String>(firstList);
for (String elem : secondList) {
    if(!firstSet.contains(item)) {
        return false;
    }
}
return true;