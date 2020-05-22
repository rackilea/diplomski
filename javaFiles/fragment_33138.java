int indexOf (String s1, String s2) {

    if (s1.length() == 0 && s2.length() == 0) {
        return 0;
    } else if (s1.length() == 0) {
        return -1;
    } else if (s2.length() == 0) {
        return 0;
    } else if (s2.length()>s1.length()) {
        return -1;
    }
    else if (s1.charAt(0)  == s2.charAt(0)) {
        int subIndex = indexOf(s1.substring(1),s2.substring(1));
        return  subIndex == -1 ? -1: subIndex;


    } else {
        int subIndex = indexOf(s1.substring(1),s2);
        return  subIndex == -1 ? -1: subIndex+1;
    }

}