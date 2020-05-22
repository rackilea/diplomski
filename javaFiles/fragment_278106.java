protected void add(String s1, String s2, String s3) {
    Map<String, String> m = null;
    m = dic.get(s1);
    if (m == null) {
        m = new HashMap<>();
    }
    m.put(s2, s3);
    dic.put(s1, m);
}