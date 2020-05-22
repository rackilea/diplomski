private static void print(String s, int i) {
    if(i == s.length() - 1)   
        System.out.println(s.charAt(i));
    else {
        System.out.print(s.charAt(i));
        print(s, i+1);
    }
}

private static void printReverse(String s, int i) {
    if(i == 0)
        System.out.println(s.charAt(0));
    else {
        System.out.print(s.charAt(i));
        printReverse(s, i-1);
    }
}