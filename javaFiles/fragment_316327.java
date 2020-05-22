public static void main(String [] args){
    String s ="abcfedbca";
    System.out.println(substring(s, 2, 5, 9));
}

    public static String substring (String s, int from, int to, int length){
            long shiftLeft = 0;
            long shiftRight = (length - to - 1) * 4;
            for(int i = 0; i < to - from - 1; i++){
                shiftLeft += 15;
                shiftLeft = shiftLeft << 4;
            }
            shiftLeft += 15;
            return Long.toHexString((Long.parseLong(s, 16) & (shiftLeft << shiftRight)) >> shiftRight);
  }