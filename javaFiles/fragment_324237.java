private static String compress(String w1) {
    StringBuilder w2 = new StringBuilder();
    int k = 0;
    for (int i = 0; i < w1.length(); i++) {
        k++;
        if(i+1>=w1.length() || w1.charAt(i) != w1.charAt(i+1)) {
          w2.append(w1.charAt(i));
          w2.append(k);
          k = 0;
        }
    }
    return ((w2.length() > w1.length())? w1: w2.toString());
}