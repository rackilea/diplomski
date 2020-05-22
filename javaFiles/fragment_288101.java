public static void main2(String[] args){
        int n = 32;
        for (int i = 0; i < Math.pow(2, n); i++){
            if (i == Integer.MIN_VALUE) {
                // i overflows
                System.out.println("i exceeded Integer.MAX_VALUE");
            }
        }
    }