private static class Message {
    short messageID = 5;
    int transactionTrace = 1;
    public short getMessageID() {
        return messageID;
    }

    public int getTransactionTrace() {
        return transactionTrace;
    }
}

private static class MessageMarshaller {
    public static byte[] toBytes(Message message) {
        ByteBuffer buffer = ByteBuffer.allocate(6);
        buffer.order(ByteOrder.BIG_ENDIAN);
        buffer.putShort(message.getMessageID());
        buffer.putInt(message.getTransactionTrace());
        return buffer.array();
    }
}

public static void main(String[] args) {
    System.out.println(Arrays.toString(MessageMarshaller.toBytes(new Message()))); 
    // ==> Outputs [0, 5, 0, 0, 0, 1]
}