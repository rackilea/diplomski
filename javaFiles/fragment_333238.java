public String gooD(String arr[]) {
    String digits = "0123456789";
    int low = 0;
    int ilow = 0; // first string by default
    int check = 0;
    String s;
    String d = "";
    for (int i = 0; i < arr.length; i++) {
        s = arr[i];
        check = 0;
        for (int j = 0; j < s.length() - 1; j++) {
            if (digits.indexOf(s.substring(j, j + 1)) != -1) {
                if (s.substring(j + 1, j + 2).equals("x")) {
                    check += 1;
                }
            }
        }
        if (check > low) { // only is strictly longer
            low = check;
            ilow = i; // keep the index of first longer string
        }
    }
    return arr[ilow]; // return the string
}