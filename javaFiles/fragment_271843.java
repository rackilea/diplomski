public static int indexOf(String s1, String s2){
    if(s1.length()<s2.length()) {
        return -1;
    }
    else if(s1.substring(0, s2.length()).equals(s2)) {
        return 0;
    }
    else {
        int i = indexOf(s1.substring(1, s1.length()), s2);
        if (i == -1) {
            return i;
        } else {
            return 1 + i;
        }
    }
}