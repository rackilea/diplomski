int x = your_integer;
        String strNum = "" + x;
        int c = 0;
        for (int i = 0; i < strNum.length(); i++) {
            if (strNum.charAt(i) == '0') {
                c++;
            }
        }