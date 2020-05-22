// The magic
public static List<Character> getPrefix(String str1, String str2) {

    return IntStream
        .range(0, Math.min(str1.length(), str2.length()))
        .mapToObj(i -> new char[] { str1.charAt(i), str2.charAt(i) })
        .takeWhile(a -> a[0] < a[1])
        .map(a -> a[0])
        .collect(Collectors.toList());

}