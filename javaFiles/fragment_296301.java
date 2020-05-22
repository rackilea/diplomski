Map<String,String> map = new HashMap<>();
Pattern p = Pattern.compile(regex);
Matcher m = p.matcher(data);
while(m.find()){
    map.put(m.group("number"), m.group("value"));
}