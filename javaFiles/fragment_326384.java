List<String> strs = Arrays.asList("311001","311 001","ds311001NM","ds311 001NM","asd,.;546798;l';","asd,.;546798;l';","asd,.; 546798;l';","asd,.; 546798 ;l';","asd,.; 546 798 ;l';","asd,.;546 798 ;l';");
Pattern p = Pattern.compile("\\d{3}\\s*\\d{3}");
for (String str : strs) {
    Matcher m = p.matcher(str);
    if (m.find()) {
        System.out.println(m.group());
    }
}