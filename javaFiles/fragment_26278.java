public static getArrayString(int[] array, char separator) {
    if(array == null || array.length == 0) return "";

    String separatorString = String.valueOf(separator);
    StringJoiner sj = new StringJoiner(separatorString);

    for(int element : array) {
        sj.add(String.valueOf(element));
    }

    return sj.toString();
}