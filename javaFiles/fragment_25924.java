public class DeserializationEventHandler implements ValidationEventHandler
{
private static final Logger LOG = LoggerFactory.getLogger(DeserializationEventHandler.class);

@Override
public boolean handleEvent(ValidationEvent event)
{
    LOG.warn("Error during XML conversion: {}", event);

    if (event.getLinkedException() instanceof NumberFormatException)
        return false;

    return true;
}