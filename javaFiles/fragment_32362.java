public class DataConnector implements DataManager {
   DataCreate creator = new DataCreate();
   @Override
   public Data readData() {
       return creator.readData();
   };
   @Override
   public void writeData() {
       creator.writeData();
   };
   public Connection getConnection() {...};
   public void close() {...};
}