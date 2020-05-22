public static boolean follows2(String s, String a, String b, String c) {
        boolean res = true;
        for (int i = 0; i < s.length(); i++) {
            if (charAtPos(s, i).equals(a)) {
                if (!(charAtPos(s, i + 1).equals(b)) || !(charAtPos(s, i + 2).equals(c))) {
                    res = false;
                }
            }
        }
        return res;
    }