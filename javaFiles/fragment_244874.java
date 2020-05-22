public static void printDups(String s1) {
    int count = 0;
    for (int i = 0; i < s1.length(); i++) {
        for (int j = 0; j < s1.length(); j++) {
            if (s1.charAt(i) == s1.charAt(j)) {
                count++;
            }

        }

        System.out.println(s1.charAt(i) + " --> " + count);
        s1 = s1.replaceAll(s1.charAt(i) + "", "");
      i--;
        count = 0;
    }


}