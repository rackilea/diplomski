private static Object safeDuplicate(Object message) {
    if (message instanceof ByteBuf) {
        return ((ByteBuf) message).retainedDuplicate();
    } else if (message instanceof ByteBufHolder) {
        return ((ByteBufHolder) message).retainedDuplicate();
    } else {
        return ReferenceCountUtil.retain(message);
    }
}