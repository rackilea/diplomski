private void logAction(Log log, String s) throws NotesException {
    int SPLIT = 256;
    for (int pos = 0; pos < s.length(); pos += SPLIT) {
        log.logAction(s.substring(pos, Math.min(s.length(), pos + SPLIT)));
    }       
}