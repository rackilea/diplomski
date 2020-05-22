public static LinkedList<String> getData(TypeEnum types) {
    LinkedList<String> listOfPaths = new LinkedList<String>();
    LinkedHashSet<String> uniques = new LinkedHashSet<String>();
    String prefix = types.equals(TypeEnum.PARTIAL) ? TypeEnum.PARTIAL.value() : TypeEnum.UNPARTIAL.value();
    uniques.add(prefix + LOCAL_PATH); // first element in the list is always LOCAL PATH
    for (String path : REMOTE_PATH) {
        uniques.add(prefix + path);
    }
    listOfPaths.addAll(uniques);
    return listOfPaths;
}