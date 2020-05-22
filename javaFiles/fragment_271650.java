String regex = "fields\\[['\"]([\\w\\s]+)['\"]\\]";
ArrayList<String> arL = new ArrayList<String>();
Pattern p = Pattern.compile(regex);
Matcher m = p.matcher(expression);

while(m.find()){
    arL.add(m.group(1));
}