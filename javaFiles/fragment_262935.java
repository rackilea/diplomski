public static ArrayList<String> combinations(String nChars, int k) {
    int n = nChars.length();
    ArrayList<String> combos = new ArrayList<String>();
    if (k == 0) {
        combos.add("");
        return combos;
    }
    if (n < k || n == 0)
        return combos;
    String last = nChars.substring(n-1);
    combos.addAll(combinations(nChars.substring(0, n-1), k));
    for (String subCombo : combinations(nChars.substring(0, n-1), k-1)) 
        combos.add(subCombo + last);

    return combos;
}

public static void main(String[] args) {
    String nChars = "ABCDE";
    System.out.println(combinations(nChars, 2));
}

output: [AB, AC, BC, AD, BD, CD, AE, BE, CE, DE]