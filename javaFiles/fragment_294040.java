public static boolean q2(String str1, String str2) {

        for(int i = 0; i <= str2.length()-str1.length(); i++) {
            String sub = str2.substring(i, i+str1.length());
            if (sub.equals(str1)) {
                return true;
            }
        }
        return false;
    }