DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
Document doc = domFactory.newDocumentBuilder().parse(file.getAbsolutePath());

update(doc, "configuration/param1", "4.0");
update(doc, "configuration/param2", "asdf");
update(doc, "configuration/test/param3", "true");