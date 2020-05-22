try{
Element FICHADAS = new Element("FICHADAS");
Document doc = new Document(FICHADAS);
doc.setRootElement(FICHADAS);
Element fichada = new Element("fichada");
fichada.addContent(new lement("N_Terminal").setText("XX"));
fichada.addContent(new Element("Tarjeta").setText("XX"));
fichada.addContent(new Element("Fecha").setText("XX"));
fichada.addContent(new Element("Hora").setText("XX"));
fichada.addContent(new Element("Causa").setText("XX"));
doc.getRootElement().addContent(fichada);
XMLOutputter xmlOutput = new XMLOutputter();
xmlOutput.setFormat(Format.getPrettyFormat());
xmlOutput.output(doc, new FileWriter("generatedXml.xml"));
} catch(IOException){
  // handle the exception.

}