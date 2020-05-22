@Override
public int compare(String o1, String o2) {
    String[] p1 = o1.split(" ", 2);
    String[] p2 = o2.split(" ", 2);
    try {
        int n1 = Integer.parseInt(p1[0]);
        int n2 = Integer.parseInt(p2[0]);
        if (n1 != n2) {
            return n1 - n2;
        }
        boolean s1 = p1.length > 1 && p1.equals("S");
        boolean s2 = p2.length > 1 && p2.equals("S");
        if (s1 && !s2) {
            return -1;
        }
        if (!s1 && s2) {
            return 1;
        }
    } catch (NumberFormatException e) {
    }
    return o1.compareTo(o2);
}