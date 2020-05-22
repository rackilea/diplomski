public static void main(String[] args) {
    String str = "hello mY dEAr friends";
    Set<String> ban = new HashSet<>(Arrays.asList("my", "dear"));
    String result = Arrays.stream(str.split("\\s"))
                          .map(s -> capitalize(s, ban))
                          .collect(Collectors.joining(" "));
    System.out.println(result);
}

static String capitalize(String s, Set<String> ban) {
    String lc = s.toLowerCase();
    return ban.contains(lc) ? lc 
                            : Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
}