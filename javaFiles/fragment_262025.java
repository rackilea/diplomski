Set<String> exceptions = new HashSet<String>(...);
for (String street : streets) {
    String[] words = street.split(" ");
    StringBuilder res = new StringBuilder();
    for (String word : words) {
        if (!exceptions.contains(word)) {
            res.append(word).append(" ");
        }
    } 
    System.out.println(res);
}