List<List<String>> outList = new ArrayList<>();
Set<String> uniques = new HashSet<>();

for (var tempList : list) {
    List<String> oneDimension = new ArrayList<>();
    for (var string : tempList) {
        if (uniques.add(string)) // add will return true if string was actually added to Set
            oneDimension.add(string);
        else
            oneDimension.add("n/a");
        }
    }
    outList.add(oneDimension);
}