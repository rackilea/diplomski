private static void printPathInChild2(String path,String prefix) {
    if (path.length() == 0) {
        return;
    }
    if (path.charAt(0) == '{') {
      printPathInChild2(path.substring(1),prefix + "-");
    } else if (path.charAt(0) == '}') {
      printPathInChild2(path.substring(1),prefix.substring(0,prefix.length()-1));
    } else {
      System.out.println (prefix.substring(1) + path.charAt(0));
      printPathInChild2(path.substring(1),prefix);
    }
}