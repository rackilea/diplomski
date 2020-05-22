/**
 * True if the converter should not convert the message payload to a String.
 * Ignored if a {@link BytesMessageMapper} is provided.
 *
 * @param payloadAsBytes The payloadAsBytes to set.
 * @see #setBytesMessageMapper(BytesMessageMapper)
 */
public void setPayloadAsBytes(boolean payloadAsBytes) {
    this.payloadAsBytes = payloadAsBytes;
}