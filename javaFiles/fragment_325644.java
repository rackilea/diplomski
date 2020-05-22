static String removeDuplicates(String key, String s) {
    int idx = key.indexOf(s);
    if (idx == -1)
        return key; // Nothing to remove
    StringBuilder buf = new StringBuilder();
    int prev = 0;
    for (int start = idx + s.length(); (idx = key.indexOf(s, start)) != -1; prev = start = idx + s.length())
        buf.append(key.substring(prev, idx));
    return (prev == 0 ? key : buf.append(key.substring(prev)).toString());
}