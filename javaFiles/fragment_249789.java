public class ExampleClient {

    private final DataPersister dataPersister;

    public ExampleClient(DataPersister dataPersister) {
        this.dataPersister = dataPersister;
    }

    public void methodThatUsesSave(){
        dataPersister.save(data);
    }
}