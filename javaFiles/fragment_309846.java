Document doc = (Document) builder.build(YourFileName);
Element rootNode = doc.getRootElement();
List<Element> childrenNode = rootNode.getChildren();
      for (Element child : childrenNode) {
           System.out.println(child.getAttribute("value").getIntValue());
           child.getAttribute("value").setValue("2");
      }

// print updates to xml file with good formatting
XMLOutputter xmlOutput = new XMLOutputter();
xmlOutput.setFormat(Format.getPrettyFormat());
xmlOutput.output(doc, new FileWriter(YourFileName));