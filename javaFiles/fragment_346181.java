static void pattern(String n) {
        int len = n.length();
for (int i = 0; i < len; i++) {
    for (int j = 0; j < len; j++) {
        if((i<j)&&(i>len-j-1) || (i>j)&&(i<len-j-1)) {
            System.out.printf("- ");

        } else  {
            System.out.printf("%c ", n.charAt(i));
        }
    }
    System.out.printf("%n");
}