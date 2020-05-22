public class CSVReader extends DataReader<List<String>> {

   private final ICsvListReader reader; 

   ...

   @Override
   public List<String> readNext() throws IOException {
      return reader.read(); //read already throws an IOException so you're good to go
   }
}