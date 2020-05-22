public static void main(String[] args) {
    String line = "HEY_YO NICE GUYHERE";
    Pattern r = Pattern.compile("[a-zA-Z]+_[a-zA-Z]+");
    Matcher m = r.matcher(line);
    if (m.find()) {
        System.out.println("Found: " + m.group(0));
    } else {
        System.out.println("Not found");
    }

}