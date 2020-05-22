public static String generate(String prefix, int k) {
        String s = "";
        if (k == 0)
            return prefix + "_";

        for (char c : charArray) {
            String newPrefix = prefix + c;
            s = s + generate(newPrefix, k - 1); 
        }
        return s;
    }