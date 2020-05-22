public List<String> splitStringEqually(String txtStr, int subStringSize) {
    List<String> splittedStringList = new ArrayList<String>();
    for (int start = 0; start < txtStr.length(); start += subStringSize) {

        splittedStringList.add(txtStr.substring(start, Math.min(txtStr.length(), start + subStringSize)));
    }
    return splittedStringList;
}