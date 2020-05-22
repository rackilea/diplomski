private static void print(String str) {
    if (! str.isEmpty())
        print(str, (str.length() - 1) / 2, 1, (str.length() - 1) | 1);
}
private static void print(String str, int indent, int leftLen, int rightIdx) {
    for (int i = 0; i < indent; i++)
        System.out.print(' ');
    System.out.println(str.substring(0, leftLen) + str.substring(rightIdx));
    if (leftLen < rightIdx)
        print(str, indent - 1, leftLen + 1, rightIdx - 1);
}