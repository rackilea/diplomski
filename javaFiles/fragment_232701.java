public static boolean isAllEmptyOrNull(Collection... collectionList) {
    return Arrays.stream(collectionList).allMatch(Collection::isEmpty);
}

public static boolean isAllEmptyOrNull(Map... maps) {
    return Arrays.stream(maps).allMatch(Map::isEmpty);
}