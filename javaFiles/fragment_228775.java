public static void main(String[] args) {
    int dec = 64;
    StringBuilder sb = new StringBuilder();
    int  rem = 0;
    while (dec != 0) {
        rem = dec % 2;
        sb.insert(0,rem);
        dec = dec / 2;
    }
    System.out.println("In Binary = " + sb.toString());
}