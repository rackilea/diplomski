static final String SUPDIGITS = "\u2070\u00b9\u00b2\u00b3\u2074\u2075\u2076\u2077\u2078\u2079";

public static void main(String[] args) throws IOException {        

   StringBuilder sb = new StringBuilder();
   for(int i = 1; i< 50; i++) {
       sb.setLength(0);

       //append digits in reverse order
       int v = i;
       for (;v>0;v/=10) {
           sb.append(SUPDIGITS.charAt(v%10));
       }
       //and then the 3
       sb.append("3");
       //and then reverse it
       sb.reverse();
       System.out.append(sb).println();
   }
}