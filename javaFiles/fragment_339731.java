public String[] permutations(String str) {
    if (str.length() == 0) {
        return new String[0];
    } else if (str.length() == 1) {
        String[] s = new String[1];
        s[0] = str;
        return s;
    }
    Set<String> permutations = new HashSet<>();
    for (int i = 0; i < str.length(); i++) {
        char c = str.charAt(i);
        String part = str.substring(0, i) + str.substring(i + 1);
        String[] rem = permutations(part);
        for (String s : rem) {
            permutations.add(s);
            for (int j = 0; j <= s.length(); j++) {
                String t = s.substring(0, j) + c + s.substring(j);
                permutations.add(t);
            }
        }
    }
    return permutations.toArray(new String[permutations.size()]);
}