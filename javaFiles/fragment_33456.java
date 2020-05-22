ObjectFactory factory = Context.getWmlObjectFactory();
WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage
        .createPackage();

P spc = factory.createP();
R rspc = factory.createR();

Text t1 = factory.createText();
t1.setValue("tset");
rspc.getContent().add(t1);
Br br = factory.createBr(); // this Br element is used break the current and go for next line
rspc.getContent().add(br);
Text t2 = factory.createText();
t2.setValue("\r\n tset2");
rspc.getContent().add(t2);

spc.getContent().add(rspc);

wordMLPackage.getMainDocumentPart().addObject(spc);

wordMLPackage.save(new java.io.File("helloworld.docx"));