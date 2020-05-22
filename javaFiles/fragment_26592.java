Set<String> set1 = new HashSet<>(Arrays.asList(str1.split(",")));
Set<String> set2 = new HashSet<>(Arrays.asList(str2.split(",")));
if (set2.containsAll(set1)) {
    System.out.print("YES");
}
else {
    System.out.print("NO");
}