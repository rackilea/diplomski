public String[] splitInSubstrings (String str, int len) {
    int siz = (int)Math.ceil((double)str.length() / (double) len);
    String[] res = new String[siz];
    int idx = 0;
    for(int i = 0; i < res.length; i++) {
        int end_idx = ((idx + len) >= str.length()) ? str.length() : (idx + len);
        res[i] = str.substring(idx, end_idx); 
        idx += len;
    }
    return res;
}