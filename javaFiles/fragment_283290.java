public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String collection; 
    String filename;

    System.out.println("Enter the collection name: ");
    collection = br.readLine();

    String urlString = "http://localhost:8983/solr/" + collection;
    solr = new HttpSolrClient(urlString);

    doc1 = new SolrInputDocument ();

    System.out.println("Enter the file name: ");
    while ((filename = br.readLine()) !=null && filename.trim().length()>0){
        System.out.println("Inside reading file ");
        parseUsingStringTokenizer(filename);
        System.out.println("Enter the file name: ");
    }
    System.out.println("Program will exit now...");
}