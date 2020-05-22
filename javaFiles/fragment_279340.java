public static void triangleWord (java.lang.String s) {
    for (int i=s.length()-1; i >= 0; --i) {
        String spaces = new String(new char[i]).replace("\0", " ");
        System.out.println(spaces + s.substring(i));
    }
}