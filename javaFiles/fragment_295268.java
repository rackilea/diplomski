switch (state) {
case READ_HEADER:
    if (msg.remaining() > 0) {
        channel.read(msg, null, this);
        return;
    }
    // do the parsing the IP and length
    state = READ_PAYLOAD;
    channel.read(payloadBuf, null, this);
    break;

case READ_PAYLOAD:
    if (payloadBuf.remaining() > 0) {
        channel.read(payloadBuf, null, this);
        return;
    }
    payloadBuf.flip();
    // get content from payloadBuf
    break;
}