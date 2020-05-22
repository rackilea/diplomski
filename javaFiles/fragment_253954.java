@Component
public class ChunkSizeListener extends StepListenerSupport<Object, Object> {

    private FileWriter fileWriter;

    public ChunkSizeListener() {
        // not sure if you should keep the super() or not
        super();
    }

    public ChunkSizeListener(File file) throws IOException {
        fileWriter = new FileWriter(file, true);
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        try {
            fileWriter.close();
        } catch (IOException e) {
            System.err.println("Unable to close writer");
        }
        return super.afterStep(stepExecution);
    }

    @Override
    public void beforeChunk(ChunkContext context) {
        try {
            fileWriter.write("your custom header");
            fileWriter.flush();
        } catch (IOException e) {
            System.err.println("Unable to write header to file");
        }
    }
}