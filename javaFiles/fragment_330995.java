Elements elems = doc.select("table#thetable td");
List<String> strings = new ArrayList<String>();

for (Element e : elems) {
    strings.add(e.text());
}