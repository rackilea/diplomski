Document document = Jsoup.parser(html);
List<String> tags = new ArrayList<String>();
for(Element e : document.select("a")){
    tags.add(e.tagName());
}
System.out.println("The tags = " + tags);

//If you want it as array
String[] tagsArray = tags.toArray(new String[tags.size()]);