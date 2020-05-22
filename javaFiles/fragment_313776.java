@Component
public class StartupComponent implements CommandLineRunner {
   private final StorageProperties storageProps;

   public StartupComponent (StorageProperties storageProps){
     this.storageProps = storageProps;
   }

  @Override
  public void run(String... args) throws Exception {
     String path = storageProps.getPath();
     // do your stuff here
  }
}