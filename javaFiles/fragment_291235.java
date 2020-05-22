String matchedKey = null;

while (i.hasNext()) {
    key = i.next();
    if (s.contains(key) && (matchedKey == null || matchedKey.length() < key.length())) {
        matchedKey = key;
    }
}
if (matchedKey != null) {
    s = s.replace(matchedKey, h.get(matchedKey));
}