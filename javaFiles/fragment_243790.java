public static void getChara(String o){
    for (int row=0; row < 5; ++row){
        for (int i=0; i < o.length(); ++i){
            int digit = o.charAt(i) == '0' ? 0 : 1;
            printDigit(row, digit);
        }
        System.out.println();
    }
}