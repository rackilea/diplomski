public class CustomeFilePersistenceStrategy extends FilePersistenceStrategy {
     public CustomeFilePersistenceStrategy(File baseDirectory) {
      super(baseDirectory);
     }

    @Override
    protected String getName(final Object key){
        //put desired file naming logic
        return "CustomFile.xml";
    }
}