Pattern p = Pattern.compile("(?<=border-right-width:1px;)(.*)(?=;width:140px;)");
String elementInformation = "";
for (Element elem : names) {
    if (elem.text().contains("Montag")) {
        Matcher m = p.matcher(elem.attributes().toString());
        elementInformation = elem.text() + " -> ";
        while(m.find()){
            elementInformation += m.group();
        }
    }
}
System.out.println(elementInformation);