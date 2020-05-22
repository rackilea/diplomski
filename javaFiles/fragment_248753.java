public static void main(String[] args) {
    try {
        System.out.println(convertToInt("$123,456,789"));
    } catch (ParseException e) {
        e.printStackTrace();
    }
}