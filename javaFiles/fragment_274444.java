//you could probably make this nicer

String fileNamePattern = "CRM_CI_\\d{8}_\\d{6}_\\d{8}\\.zip";
String oldProvIdPattern = "CRM_CI_\\d{8}_\\d{6}_(\\d{8})\\.zip";

String pathToZips = "/Users/John.Smith/Desktop/Test_script/"
String destinationPath = "/Users/John.Smith/Desktop/Test_script/test";

File dir = new File(".");
FileFilter fileFilter = new RegexFileFilter(fileNamePattern);
File[] files = pathToZips.listFiles(fileFilter);
for (File file : files) {
    //Handle each zip here
    String zipPath = file.getAbsolutePath();  


    try {
        unzipper.unzip(zipPath, destinationPath);
    } catch (Exception ex) {
        System.out.println("ERROR:Unzip did not work");
    }

    Pattern pattern = Pattern.compile(oldProvIdPattern);
    Matcher matcher = pattern.matcher(file.getName());
    if (matcher.find()){
        String old_prov_id = matcher.group(1);
        System.out.println("Old provider ID :"+old_prov_id );

        // add +1 to provider ID
        int new_provider_ID = Integer.parseInt(old_prov_id);
        new_provider_ID++;
        System.out.println("New provider ID :"+new_provider_ID );

        // convert provider-id INT into String   

        String str_provider_id = Integer.toString(new_provider_ID);  
        System.out.println("New String provider ID :"+str_provider_id );  

        // concatenate two String into one
        StringBuilder bufferPDF = new StringBuilder()
                .append(new_provider_ID).append(".pdf");
            System.out.println(bufferPDF.toString()); 

            StringBuilder bufferXML = new StringBuilder()
                    .append(new_provider_ID).append(".xml");
                System.out.println(bufferXML.toString()); 

        // convert names of XML and PDF      

       Path sourcePDF = Paths.get("/Users/John.Smith/Desktop/Test_script/test/" + old_prov_id + ".pdf");
        try {
            Files.move(sourcePDF, sourcePDF.resolveSibling(bufferPDF.toString()));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Path sourceXML = Paths.get("/Users/John.Smith/Desktop/Test_script/test/" + old_prov_id + ".xml");
        try {
            Files.move(sourceXML, sourceXML.resolveSibling(bufferXML.toString()));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // change provider-id and filename in xml file    

        try {

        String filepath = "/Users/John.Smith/Desktop/Test_script/test/" + old_prov_id + ".xml";

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(filepath);

        // Get the root element provider-id 
        Node provider = doc.getElementsByTagName("provider-id").item(0);
        provider.setTextContent(str_provider_id);

        // Get the root element filename
        Node filename = doc.getElementsByTagName("filename").item(0);
        filename.setTextContent(str_provider_id);


        // write the content into xml file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(filepath));
        transformer.transform(source, result);

        System.out.println("Done");

       } catch (ParserConfigurationException pce) {
        pce.printStackTrace();
       } catch (TransformerException tfe) {
        tfe.printStackTrace();
       } catch (IOException ioe) {
        ioe.printStackTrace();
       } catch (SAXException sae) {
        sae.printStackTrace();
       }            

      }  
}