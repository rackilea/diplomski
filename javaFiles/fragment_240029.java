static char getDigit(String N, int d) {  
        return N.charAt(N.length() - d);  
    }

    static char getDigit(int N, int d) {
        String str = String.valueOf(N);
        return str.charAt(str.length() - d);  
    }