String s = "{name = abc, address = xyz, abc, school = mno}";
HashMap<String, String> map = new HashMap<String, String>();
for (String element : s.replaceAll("[{}]", "").split("(,(?=[^,]+=))")) {
    String[] entry = element.split("=");
    map.put(entry[0].trim(), entry[1].trim());
}