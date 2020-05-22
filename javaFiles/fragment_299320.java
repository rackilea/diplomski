class binary {
    public static void main(String[] args)
    {
        int myBinary = binary2decimal("1100");
        System.out.println(myBinary); 
       //System.out.println(binary2decimal("1100")); 
    }
static int binary2decimal(String b) {
    int len = b.length();
    if (len == 0) return 0;
    String now = b.substring(0,1);
    String later = b.substring(1);
    return Integer.parseInt(now) * (int)Math.pow(2, len-1) + binary2decimal(later);     
  }
}