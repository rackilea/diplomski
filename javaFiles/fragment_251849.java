XMLOutputter outputter = new XMLOutputter();
outputter.getFormat().setExpandEmptyElements(true);
SAXBuilder jdomBuild = new SAXBuilder();
Document jdomDoc = jdomBuild.build(new ByteArrayInputStream(("<xml_report>\n"
        + "\n"
        + "    <header_info>\n"
        + "        <bla1></bla1>\n"
        + "        <bla2></bla2>\n"
        + "        <bla3></bla3>\n"
        + "        <bla4></bla4>\n"
        + "        <bla5></bla5>\n"
        + "        <bla6></bla6>\n"
        + "    </header_info>\n"
        + "\n"
        + "    <random_things>\n"
        + "        <random/>\n"
        + "    </random_things>\n"
        + "\n"
        + "</xml_report>").getBytes(StandardCharsets.UTF_8)));
Element root = jdomDoc.getRootElement();
Element header = root.getChild("header_info");
Comment comment = new Comment(outputter.outputString(header));
root.setContent(root.indexOf(header), comment);
outputter.output(jdomDoc, System.out);