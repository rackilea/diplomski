public static void main(String[] args) {
    final String s = "10067829311288";
    final List<Integer> split = new LinkedList<>();
    int i = 0;
    while (i < s.length()) {
        final char c = s.charAt(i);
        final int remain = s.length() - i;
        final int step;
        if (c == '1') {
            step = Math.min(remain, 3);
        } else {
            step = Math.min(remain, 2);
        }
        split.add(Integer.parseInt(s.substring(i, i + step)));
        i += step;
    }
    System.out.println(split);
}