String S = "No one could disentangle correctly";
String W[] = S.split(" ");
Arrays.sort(W, new java.util.Comparator<String>() {
    @Override
    public int compare(String s1, String s2) {
        // TODO: Argument validation (nullity, length)
        return s1.length() - s2.length();// comparision
    }
});