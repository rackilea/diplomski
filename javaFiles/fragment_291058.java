public static String unAccent(String s) {
    //http://www.rgagnon.com/javadetails/java-0456.html
    String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
    Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
    return pattern.matcher(temp).replaceAll("");
}