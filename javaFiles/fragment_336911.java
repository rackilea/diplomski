public class AtmosphereHandler extends AbstractReflectorAtmosphereHandler {

private static Logger logger = Logger.getLogger(AtmosphereHandler.class);;

@Override
public void onRequest(final AtmosphereResource ar) throws IOException {
    logger.info("Connecting to comet with: "
            + ar.getRequest().getRequestURI());
    Broadcaster broadcaster = BroadcasterFactory.getDefault().lookup(
            YOUR_CLIENT_ID, true);
    if (broadcaster.getAtmosphereResources().size() > 0) {
        logger.debug("Broadcaster recovered with name: "
                + broadcaster.getID());
    } else {
        logger.debug("Broadcaster created with name: "
                + broadcaster.getID());
    }
    ar.setBroadcaster(broadcaster);

    ar.setSerializer(new Serializer() {
        Charset charset = Charset.forName(ar.getResponse()
                .getCharacterEncoding());

        @Override
        public void write(OutputStream os, Object o) throws IOException {
            try {
                logger.info("Writing object to JSON outputstream with charset: "
                        + charset.displayName());
                String payload = serializer.serialize(o);
                os.write(payload.getBytes(charset));
                os.flush();
            } catch (SerializationException ex) {
                throw new IOException("Failed to serialize object to JSON",
                        ex);
            }
        }
    });

    ar.suspend();

}

private ServerSerializer serializer = new JacksonSerializerProvider()
        .getServerSerializer();