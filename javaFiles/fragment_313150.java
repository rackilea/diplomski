public class UpdateOrderPickedStatusRequest {

    private MessageHeader header;

    @XmlElement(name = "MessageHeader")
    public MessageHeader getHeader() {
        return header;
    }

    public void setHeader(MessageHeader header) {
        this.header = header;
    }
}