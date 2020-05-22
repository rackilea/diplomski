String str = "@import \"/css/screen/shared/styles.css\";\n@import \"/css/screen/nol/styles.css\";"; 
Pattern ptrn = Pattern.compile("@import\\s*\"([^\"]*)\";");
Matcher matcher = ptrn.matcher(str);
while (matcher.find()) {
    System.out.println(matcher.group(1));
}