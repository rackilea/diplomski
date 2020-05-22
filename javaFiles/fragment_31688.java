//tell the location of all of import file 
transformFactory.setURIResolver(new ClassPathURIResolver());

//cache XSLT source file for transformation reuse
InputStream is = this.getClass().getClassLoader().getResourceAsStream(xsltFile);
javax.xml.transform.Source xsltSource = new javax.xml.transform.stream.StreamSource(is);