public static void main(String[] args) {
    int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 88, 99, 101};
    String s = "x(10, 9, 8)";

    Pattern p = Pattern.compile("\\d+");
    Matcher m = p.matcher(s);
    StringBuilder replace = new StringBuilder();
    int start = 0;
    while(m.find()) {
        //append the non-digit part first
        replace.append(s.substring(start, m.start()));
        start = m.end();
        //parse the number and append the number in the array at that index
        int index = Integer.parseInt(m.group());
        replace.append(array[index]);
    }
    //append the end of the string
    replace.append(s.substring(start, s.length()));

    System.out.println(replace);
}