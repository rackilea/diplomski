public static void main(String[] args) {
    String t = "2014-05-11T09:00:01.772401";
    final String pattern = "yyyy-MM-dd'T'hh:mm:ss.SSSSSS";
    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    try {
        sdf.parse(t);
        System.out.println("Valid");
    } catch(java.text.ParseException e) {
        System.out.println("Invalid format");
    }
}