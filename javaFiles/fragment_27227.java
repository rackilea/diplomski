public void permutation(String prefix, String str) {
    int n = str.length();
    if (n==0){}
    else {
        for (int i = 0; i < n; i++)
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
    }

}