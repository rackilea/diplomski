static String removeSecond(String key, String s) {
    int idxFirst = key.indexOf(s);
    if (idxFirst != -1) {
        int idxSecond = key.indexOf(s, idxFirst + s.length());
        if (idxSecond != -1) {
            return key.substring(0, idxSecond) +
                   key.substring(idxSecond + s.length());
        }
    }
    return key; // Nothing to remove
}