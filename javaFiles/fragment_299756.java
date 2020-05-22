public static void main(String[] args) {
    String str = "<script type=\"text/javascript\">"
            + "toastr.error('ERROR1');"
            + "toastr.error('ERROR2');"
            + "..."
            + "</script>";
    String regexString = Pattern.quote("toastr.error('") + "(.*?)" + Pattern.quote("');");
    Pattern pattern = Pattern.compile(regexString);
    Matcher matcher = pattern.matcher(str);
    while (matcher.find()) {
        System.out.println(matcher.group(1));
    }
}