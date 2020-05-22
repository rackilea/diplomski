String s = "ABC";
    String t = "DEFGH";
    StringBuilder merge = new StringBuilder();
    for (int i = 0; i < s.length() || i < t.length(); i++) {
        if (i < s.length()) {
            merge.append(s.charAt(i));
        }
        if (i < t.length()) {
            merge.append(t.charAt(i));
        }
    }

    System.out.println(merge.toString());