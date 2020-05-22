public void tt() {
    // you could ignore the ImmutableList stuff, it just prepares the string list, nothing more.
    final List<String> l = ImmutableList.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j");
    final int col = 3;
    final int size = l.size();
    final int n = size / col;
    final StringBuffer sb = new StringBuffer("");
    for (int i = 0; i <= n; i++) {
        int k = i;
        sb.append("<tr>\n");
        while (k < size) {
            sb.append("<td>" + l.get(k) + "</td>");
            k += n + 1;
        }
        sb.append("\n</tr>\n");
    }
    System.out.println(sb.toString());
}