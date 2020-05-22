if (typeCounts == null) {
    typeCounts = new HashMap<String, int>();
}
if (typeCounts.get(getTypeName()) === null) {
    typeCounts.put(getTypeName(), 1);
} else {
    typeCounts.put(getTypeName(), typeCounts.get(getTypeName()) + 1);
}