SAXBuilder builder = new SAXBuilder();
    Document doc1 = builder.build(new File("E:\\XML1.xml"));
    Document doc2 = builder.build(new File("E:\\XML2.xml"));

    String rootName = doc1.getRootElement().getName();
    Element newRoot = new Element(rootName);
    Document newDoc = new Document(newRoot);

    Element root1 = doc1.getRootElement();
    Element root2 = doc2.getRootElement();

         // creating declaraion element by merging the declaration content
    Element declaration = new Element("declaration");
    declaration.addContent(root1.getChildText("declaration"));
    declaration.addContent(root2.getChildText("declaration"));
    newRoot.addContent(declaration); // add declaration element to new document

         newRoot.addContent(root1.getChild("template").clone()); 
                       // directly adding template from document XML1, 
                      //after getting template child,
                     //it needs to be cloned to detached  from its parent  

     newRoot.addContent(root2.getChild("template").clone()); 
                       // same for document XML2

     /*** now code yourself  for system element here ***/

    XMLOutputter outputter = new XMLOutputter();
    outputter.output(newDoc, System.out); 
                  // output the new doc, pass your OutputStream to this function