public static void main(String[] args) throws ParseException {
        String newString = "[{8} , {11} , {19} , {21} , {34, 20, 33, 26, 17, 35, 36, 49, 4, 48, 39, 1, 10, 41, 14, 9, 7, 16, 46, 45, 29, 3, 44, 43, 38, 37, 13, 22, 23, 47, 25, 40, 2, 5, 15, 18, 30, 28, 42, 50, 12, 32, 24, 6, 31, 27}]";
        Pattern p = Pattern.compile("\\{(.*?)\\}");
        Matcher m = p.matcher(newString);
        while(m.find())
        {
            System.out.println(m.group(1).replace(",", ""));
        }
}