//WebNavigation navigation = null;
//URI uri = null;

navigation.loadURI(uri, WebNavigationConstants.LOAD_FLAGS_NONE, null, null, null);
Document doc = navigation.getDocument();
Element ex = doc.getDocumentElement();
System.out.println(ex.getTextContent()); //prints page source