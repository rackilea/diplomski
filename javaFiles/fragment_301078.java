public static final boolean equals(String a, String b) {
    if(a == null && b == null) {
        return true;
    }
    else if(a == null || b == null) {
        return false;
    }
    else {
        return a.equals(b);
    }
}