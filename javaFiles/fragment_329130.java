public static void EvenPairs(String s) {

    char[] chs = s.toCharArray();
    int count = 0;

    for (int i = 0; i < chs.length; i++) {
        for (int j = 0; j < chs.length; j++) {
            if (chs[i] == chs[j]) {
                count++;
            }
        }

        boolean shouldPrint = true;  
        for (int k = i - 1; k >= 0; k--) {  //loop though each character before the current one to check if it was already printed. 
            if (chs[k] == chs[i]) {         //if we it was already printed don't print.
                shouldPrint = false;
                break;
            }
        }

        if (shouldPrint) {
            if (count % 2 == 0)
                System.out.println(s.charAt(i) + "- true");
            else
                System.out.println(s.charAt(i) + "- False");
        }

        count = 0;
    }

}