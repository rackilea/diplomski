public static List<String> detectDuplicates(List<String> chars) {
    while(i<chars.size() && chars.get(i-1).equals(chars.get(i))) {
        chars.remove(i);
    }
    i++;

    if(i>chars.size())  return chars;
    return detectDuplicates(chars);
}