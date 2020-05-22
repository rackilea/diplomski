List<URL> urls = new ArrayList<URL>();
Pattern p = Pattern.compile(myUrlPattern);
Matcher m = p.matcher(eachScriptTagText);
while (m.find()) {
  urls.add(m.group());
}