protected final JsonNode _fromInt(JsonParser p, DeserializationContext ctxt,
        JsonNodeFactory nodeFactory) throws IOException
{
    JsonParser.NumberType nt;
    int feats = ctxt.getDeserializationFeatures();
    if ((feats & F_MASK_INT_COERCIONS) != 0) {
        if (DeserializationFeature.USE_BIG_INTEGER_FOR_INTS.enabledIn(feats)) {
            nt = JsonParser.NumberType.BIG_INTEGER;
        } else if (DeserializationFeature.USE_LONG_FOR_INTS.enabledIn(feats)) {
            nt = JsonParser.NumberType.LONG;
        } else {
            nt = p.getNumberType();
        }
    } else {
        nt = p.getNumberType();
    }
    if (nt == JsonParser.NumberType.INT) {
        return nodeFactory.numberNode(p.getIntValue());
    }
    if (nt == JsonParser.NumberType.LONG) {
        return nodeFactory.numberNode(p.getLongValue());
    }
    return nodeFactory.numberNode(p.getBigIntegerValue());
}