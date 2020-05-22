//Here is the revised answer for you it may help

public class indexing {

    String directory="your_image_dataset";
    String index="./images__idex";//where you will put the index

   /* if you want to use BOVW based searching you can change the 
   numbers below but be careful */
     int numClusters = 2000; // number of visual words
     int numDocForVocabulary = 200; 

    /* number of samples used for visual words vocabulary building    
   this function calls the document builder and indexer function (indexFiles below)
   for each image in the data set */

  public void IndexImage() throws IOException{
      System.out.println("-< Getting files to index >--------------");
      List<String> images = FileUtils.getAllImages(new File(directory), true);
      System.out.println("-< Indexing " + images.size() + " files >--------------");
      indexFiles(images, index);    
}
/* this function builds Lucene document for each image passed to it for
the extracted visual descriptors */

private void indexFiles(List<String> images, String index) 
throws FileNotFoundException, IOException {       

 //first high level structure 
ChainedDocumentBuilder documentBuilder = new ChainedDocumentBuilder();
//type of document to be created here i included different types of visual features,    
//documentBuilder.addBuilder(new SurfDocumentBuilder());
//here choose either Surf or SIFT 
documentBuilder.addBuilder(new SiftDocumentBuilder());
documentBuilder.addBuilder(DocumentBuilderFactory.getEdgeHistogramBuilder());
documentBuilder.addBuilder(DocumentBuilderFactory.getJCDDocumentBuilder());
documentBuilder.addBuilder(DocumentBuilderFactory.getColorLayoutBuilder());

//IndexWriter creates the file for index storage 
IndexWriter iw = LuceneUtils.createIndexWriter(index, true);
int count = 0;
/*then each image in data set  called up on the created document structure
   (documentBuilder above and added to the index file by constructing the defined 
   document structure) */

 for (String identifier : images) {
    Document doc = documentBuilder.createDocument(new 
    FileInputStream(identifier), identifier);

    iw.addDocument(doc);//adding document  to index
    iw.close();// closing the index writer

/*  For searching purpose you will read the index and by constructing an instance of 
  IndexReader she you defined different searching strategy which is available in Lire
  Please check the brace and test it. */