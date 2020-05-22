Set<String> set = ...;
for (String a : set) {
    boolean bGo = false;
    for (String b : set) {
        if (bGo) {
            boolean cGo = false;
            for (String c : set) {
                if (cGo) {
                    System.out.println(a + " " + b + " " + c);
                } else if (b.equals(c)) {
                    cGo = true;
                }
            }
        } else if (a.equals(b)) {
            bGo = true;
        }
    }
}