String s = "abcd";
    String[] sources = {"a","cd"};
    int[] indexes  = {0, 2};
    String[] targets = {"eee", "ffff"};

    int more = 0;

    for (int i = 0; i < targets.length; i++) {
        int startIndex = more + indexes[i];
        int endIndex = more + indexes[i] + sources[i].length();
        if (startIndex < s.length() && endIndex <= s.length()) {
            String sBefore = s.substring(0, indexes[i] + more);
            String sAfter = s.substring(indexes[i] + sources[i].length() + more);
            if (sources[i].equals(s.substring(startIndex, endIndex))) {
                s = sBefore + targets[i] + sAfter;
                more += targets[i].length() - sources[i].length();
            }
        }
    }

    System.out.println(s);