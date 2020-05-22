public interface PersistentModel {
    boolean save (OutputStream out) throws IOException;
    boolean load (InputStream out) throws IOException;
}
public interface SpreadSheet extends PersistentModel {
    Worksheet[] getWorksheets();
    Worksheet getWorksheet(int i); // and other related, etc.
}

public interface Worksheet extends PersistentModel {
   int id();
   Element get(String name):
   Element[] getElements();

   public interface Element<T> extends PersistentModel { 
        String getName();
        T getValue();
        boolean setValue(T v);
   }
}