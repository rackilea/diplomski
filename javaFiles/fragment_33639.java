int NumberOfcopies(String t, String h){
    // t = the first string i.e "ooo"
    // h = the second string i.e "wooooooooooooooooooooow"

    String s = t + "$" + h; // adding a sentinel character in between
    int n = s.length(); // length of new string
    int[] z = new int[n]; // z array

    // Code ref : http://e-maxx-eng.github.io/string/z-function.html
    int l = 0, r = 0;
    for (int i = 1; i < n; i++){
        if (i <= r)
            z[i] = Math.min(r - i + 1, z[i - 1]);
        while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i]))
            ++z[i];
        if (i + z[i] - 1 > r){
            l = i;
            r = i + z[i] - 1;
        }
    }

    //checking for all the occurance of string t in string h
    int res = 0;
    for (int i = t.length() + 1; i < n; ){
        if (z[i] == t.length()){
            //A copy is found so skip next t.length chars
            i += t.length();
            ++res; 
        }
        else ++i;
    }
    System.out.println("Number of Occurance : " + res);
    return res;
}