PDDocument pd;

File input = new File(inputfile); // Input File

pd = PDDocument.load(input);

//Writes all embedded Filenames (from pdf document) into Logfile
try{
    PDDocumentCatalog catalog = pd.getDocumentCatalog();
    PDDocumentNameDictionary names = catalog.getNames();
    PDEmbeddedFilesNameTreeNode embeddedFiles = names.getEmbeddedFiles();
    Map<String, COSObjectable> embeddedFileNames = embeddedFiles.getNames();

    //For-Each Loop is used to list all embedded files (if there is more than one)          
    for (Map.Entry<String, COSObjectable> entry : embeddedFileNames.entrySet())
    {   
        //You might need to configure the logger first
        logger.info("Inputfile: " + inputfile +"Found embedded File: " + entry.getKey() + ":");
    }

}
catch (Exception e){
    System.out.println("Document has no attachments. ");
}