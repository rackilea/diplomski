import java.util.HashMap;
import java.util.Map;

public class Refactoring {

    private static class IonStruct {};

    private static interface MessageBuilder {
        String  build(final String xId,final String yId, final IonStruct metadataStruct);
    }


    private static class NotActiveMessageBuilder implements MessageBuilder {

        private static final String YX_NON_ACTIVE_FMT = "Y %s X %s not active: status is inactive%n;";
        private static final String Y_NON_ACTIVE_FMT = "Y %s not active: status is inactive%n";

        @Override
        public String build(String xId, String yId, IonStruct metadataStruct) {
            return (xId != null) ? String.format(YX_NON_ACTIVE_FMT, yId, xId) : String.format(Y_NON_ACTIVE_FMT, yId) ;
        }

    }

    private static enum MessageTypeChine
    {
        instance();
        private final Map<String,MessageBuilder> builders;
        private MessageTypeChine() {
            this.builders = new HashMap<>();
            this.builders.put("NOT_ACTIVE", new NotActiveMessageBuilder());
        }

        public String constructMessage(final String reason, final String xId,
                final String yId, final IonStruct metadataStruct) {
            MessageBuilder builder = this.builders.get(reason);
            if(null != builder)
                return builder.build(xId, yId, metadataStruct);

            throw new UnsupportedOperationException("Message type is not supported");
        }
    }


    public static String constructMessage(final String reason, final String xId,
            final String yId, final IonStruct metadataStruct) {
        return MessageTypeChine.instance.constructMessage(reason, xId, yId, metadataStruct);
    }

}