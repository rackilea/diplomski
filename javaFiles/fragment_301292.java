public static String myToString(List<?> list) {
    StringBuilder stringList = new StringBuilder();
    String delimiter = " ";
    for (int c = 0; c < list.size(); c++) {
        stringList.append(delimiter);
        stringList.append(list.get(c));
    }
    return stringList.toString();
}