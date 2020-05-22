public class Main {

public static void main(String[] args) throws FileNotFoundException, IOException {
    ConnectMongoDB mongo = new ConnectMongoDB();
    mongo.connectToMongoDB(createJsonFromCSV());
}

public static List<Document> createJsonFromCSV() throws IOException {
    String csvFile = "C:\\Projects\\frontKeymatch_default_frontend.csv";
    List<Document> createObjects = null;
    Pattern pattern = Pattern.compile(",");
    try (BufferedReader in = new BufferedReader(new FileReader(csvFile));){
          createObjects = in.lines().map(line ->{
             String[] x = pattern.split(line);
             return new Document("query",x[0]).append("type", x[1]) //append other fields
          }).collect(Collectors.toList());
       }
     return createObjects;
    }
}

public class ConnectMongoDB{
    public void connectToMongoDB(List<Document> docs) throws IOException {
    MongoClient mongo = new MongoClient( "localhost" ,27017);
    mongo.getDatabase("db").getCollection("collection").insertMany(docs);
    System.out.println("success");
   }
}