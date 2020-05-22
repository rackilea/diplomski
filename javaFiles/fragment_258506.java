XMLInputFactory f = XMLInputFactory.newInstance();
FileReader fr = new FileReader("somefile.xml");
XMLStreamReader reader = f.createXMLStreamReader(fr);

// process xml

reader.close();
fr.close();

//suggest using apache commons IOUtils.closeQuietly(fr); this way you
// don't have to deal with exceptions if you don't want