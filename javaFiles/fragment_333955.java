public class TimedHandler implements RequestStreamHandler {
    private static final Logger LOG = LogManager.getLogger(TimedHandler.class);

    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
        LOG.info("Started up");
        return;
    }