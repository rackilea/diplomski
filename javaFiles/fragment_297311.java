public String splitRecursive(String s) {
    if(!s.isEmpty()) {
        return s.charAt(0) + splitRecursive(s.substring(1));
    } else {
        return "";
    }
}