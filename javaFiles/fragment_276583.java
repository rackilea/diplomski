String url = "http://questions/ask/stackoverflow.xhtml";
Pattern pt = Pattern.compile("/(?![^/]*/)([^.]*)\\.");
Matcher matcher = pt.matcher(url);
if(matcher.find()) {
    System.out.println("Matched: [" + matcher.group(1) + ']');
    // prints Matched: [stackoverflow]
}