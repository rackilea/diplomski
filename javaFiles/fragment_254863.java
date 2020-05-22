public class TransformerFacade {

    private Map<Class, VendorMessageToCanonicalMessageTransformer> transformers = new HashMap<>();
    { 
        // this is like strategies, the key may be class, class name, enum value, whatever
        transformers.put(MessageA.class, new MessageXTransformer());
        transformers.put(MessageB.class, new MessageYTransformer());
    }

    public CanonicalMessage transform(VendorMessage message) {
        return transformers.get(message.getClass()).transform(message);
    }
}