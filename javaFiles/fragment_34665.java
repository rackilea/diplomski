public static void main(String[] args) {
    String s = "<sourceDocumentId>AX02_APF604_F604080</sourceDocumentId>";
    Pattern p = Pattern.compile(".*_(\\w+)");
    Matcher m = p.matcher(s);

    if (m.find()) {
        System.out.println(m.group(1));
    } else {
        System.out.println("Didn't match");
    }
}