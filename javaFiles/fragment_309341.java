private static void printPathInChild2(String path,String prefix) {
    if (path.length() == 0) {
        return;
    }
    char c = path.charAt(0);
    if (c == '{') {
      prefix = prefix + '-';
    } else if (c == '}') {
      prefix = prefix.substring(0,prefix.length()-1);
    } else {
      System.out.println (prefix.substring(1) + c);
    }
    printPathInChild2(path.substring(1),prefix);
}