public static void triangle(String str) {
    int length =str.length();
    for (int i=0; i<length;i++) {
         System.out.println(str.substring(0, i));
    }
    for (int i=length; i>0;i--) {
        System.out.println(str.substring(0, i));

    }
    //return str;  no need of this
}