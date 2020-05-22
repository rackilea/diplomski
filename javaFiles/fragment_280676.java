Pattern p = Pattern.compile("\\{.*?}");
Matcher m = p.matcher(validatePage);
while (m.find()) {
    JSONObject jsonObj = new JSONObject(m.group());
    System.out.println(jsonObj);
}