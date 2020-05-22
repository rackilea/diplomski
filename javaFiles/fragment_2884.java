@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MessageType")
public class MessageType {

    @XmlAttribute(name = "referenceId")
    protected String referenceId;
    @XmlAttribute(name = "messageType")
    protected String messageType;
    @XmlAttribute(name = "transactionIdForeignKey")
    protected String transactionIdForeignKey;
    @XmlAttribute(name = "xmlDetail")
    protected String xmlDetail;
    @XmlAttribute(name = "createdTime")
    protected BigInteger createdTime;

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String value) {
        this.referenceId = value;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String value) {
        this.messageType = value;
    }

    public String getTransactionIdForeignKey() {
        return transactionIdForeignKey;
    }

    public void setTransactionIdForeignKey(String value) {
        this.transactionIdForeignKey = value;
    }

    public String getXmlDetail() {
        return xmlDetail;
    }

    public void setXmlDetail(String value) {
        this.xmlDetail = value;
    }

    public BigInteger getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(BigInteger value) {
        this.createdTime = value;
    }

}