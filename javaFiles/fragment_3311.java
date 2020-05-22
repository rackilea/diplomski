public static List<String> createDescList(List<MyObject> objList) {
    return Optional.ofNullable(objList).orElse(Collections.emptyList()).stream()
                   .filter(Objects::nonNull)
                   .filter(obj -> isNotEmpty(obj.getData()))
                   .map(MyObject::getObjList)
                   .flatMap(List::stream)
                   .filter(Objects::nonNull)
                   .filter(obj -> isNotEmpty(obj.getDesc()))
                   .map(MySecondObject::getDesc)
                   .collect(Collectors.toList());
}

// TODO can be replaced with org.apache.commons.lang3.StringUtils.isNotEmpty() or isNotBlank()
private static boolean isNotEmpty(String str) {
    return str != null && !str.isEmpty();
}