//Create a xml file
    String xmlSample="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<specialchars>àèìòù€</specialchars>";
    try(FileOutputStream fosXmlFileOutputStreame= new FileOutputStream("test.xml")) {
        //write the file with a wrong encoding
        fosXmlFileOutputStreame.write(xmlSample.getBytes("ISO8859-15"));
    }

    try (
            FileInputStream xmlFileInputStream= new FileInputStream("test.xml");
            //read the file with the encoding declared in the xml header
            InputStreamReader inputStreamReader= new InputStreamReader(xmlFileInputStream,"UTF-8");
    ) {
        char[] cbuf=new char[xmlSample.length()];
        inputStreamReader.read(cbuf);
        System.out.println("file read with UTF-8=" + new String(cbuf)); 
        //prints
        //file read with UTF-8=<?xml version="1.0" encoding="UTF-8"?>
        //<specialchars>������</specialchars>
    }


    File xmlFile = new File("test.xml");
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    Document doc = dBuilder.parse(xmlFile);     
    //throws