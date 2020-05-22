void callOneMethod(int numStrings) {
    String[] a = new String[numStrings];
    for (int i = 0; i < numStrings; i++) {
        a[i] = "s" + i;
    }
    oneMethod(a);
}