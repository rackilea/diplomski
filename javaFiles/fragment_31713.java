public static String bingo(String s) {

    int index = s.length();
    while (index != 0)
        System.out.println(s.substring(0, index--));

    return s;
}