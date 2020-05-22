public static void main(String[] args) {
    System.out.println(mainMethod("When I was younger So much younger Than "+
    "today Информацию из файла в верхний регистр"));
}

public static String mainMethod(String input) {
    Pattern p = Pattern.compile("(\\w{4,}+|[А-Яа-яёЁ]{4,}+)");
    Matcher m = p.matcher(input);
    StringBuffer sb = new StringBuffer(input.length());
    while (m.find()) {
        char[] chars = m.group(1).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isUpperCase(c)) {
                chars[i] = Character.toLowerCase(c);
            } else {
                chars[i] = Character.toUpperCase(c);
            }
        }
        m.appendReplacement(sb, String.valueOf(chars));
    }
    m.appendTail(sb);
    return sb.toString();
}