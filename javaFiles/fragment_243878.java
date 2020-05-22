public static String add(String str1, String str2) {
    int max = Math.max(str1.length(), str2.length());
    int n1[] = new int[max];
    int n2[] = new int[max];
    for (int i = 0; i < str1.length(); i++) {
        //n1[i] = str1.charAt(str1.length() - 1 - i);
        n1[i] = Character.getNumericValue(str1.charAt(str1.length() - 1 - i));
    }
    for (int i = 0; i < str2.length(); i++) {
        //n2[i] = str2.charAt(str2.length() - 1 - i);
        n2[i] = Character.getNumericValue(str2.charAt(str2.length() - 1 - i));
    }
    int carry = 0;
    int sum[] = new int[max + 1];
    int k = 0;
    for (k = 0; k < max; k++) {
        sum[k] = (n1[k] + n2[k] + carry) % 10;
        if ((n1[k] + n2[k] + carry) >= 10) {
            carry = 1;
        } else {
            carry = 0;
        }
    }
    sum[max] = carry;
    StringBuilder sb = new StringBuilder();
    if (sum[max] > 0) {
        sb.append(String.valueOf(sum[max]));
    }
    for (int i = max - 1; i >= 0; i--) {
       sb.append(String.valueOf(sum[i]));
    }  
    return sb.toString();
}