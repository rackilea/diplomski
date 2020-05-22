public static void main(String[] args) {
    String test = "r_d_type= (null)\n" +
                  "StatusCode # 0 = 0";

    Pattern pattern = Pattern.compile("StatusCode.* = (\\d*)");

    Matcher matcher = pattern.matcher(test);

    if (matcher.find()) {
        System.out.println("status code: " + matcher.group(1));
    }
}