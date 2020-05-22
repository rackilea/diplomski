Document document = null;
File scores = new File("scores.xml");
if (scores.exists()) {

    document = documentBuilder.parse("scores.xml");

} else {

    document = documentBuilder.newDocument();
    document.appendChild(document.createElement("scores"));

}