String str = "12.123.123/1234-11";
StringBuilder digits = new StringBuilder();

Matcher matcher = Pattern.compile("\\d+").matcher(str);

while (matcher.find()) {
    digits.append(matcher.group());
}

System.out.println(digits);