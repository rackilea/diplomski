public static void between(char a, char b) {
    System.out.println(a);
    if (a < b){
        between((char) (a+1), b);
    }
}