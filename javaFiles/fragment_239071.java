String[] arr = { "user_id", "user_name", "country_province_city" };
for (String str : arr) {
    StringBuilder sb = new StringBuilder(str);
    int pos;
    while ((pos = sb.indexOf("_")) > -1) {
        String ch = sb.substring(pos + 1, pos + 2);
        sb.replace(pos, pos + 2, ch.toUpperCase());
    }
    System.out.printf("%s = %s%n", str, sb);
}