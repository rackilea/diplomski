public class CSVReader<T extends List<E>> extends DataReader<T> {
   ...
   @Override
   public List<E> readNext() throws IOException {
       ... 
   }
}