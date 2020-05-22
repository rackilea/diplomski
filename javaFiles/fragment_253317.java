public static void main(String[] args) throws ParseException {
    String text = "Some string here";
    String substr = "string";
    if(text.contains(substr)) {
        int index =  text.indexOf(substr);
        System.out.println(index);
    }
}