public class SpringNoConextDataReaderClient {
    @Autowired
    protected TextFileReaderProvider readerProvider;

    public SomeResult doMyComputation() {
        IReader r = readerProvider.createReader();
        try {
            // compute the result
            return theResult;
        } finally {
            r.close();
        }
    }
}