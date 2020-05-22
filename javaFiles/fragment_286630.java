@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "Message", propOrder = {
    "memberOne",
    "memberTwo",
    "messageBodyChoice"
})
public class Message{

    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(HexBinaryAdapter.class)
    @XmlSchemaType(name = "hexBinary")
    protected byte[] memberOne;

    @XmlSchemaType(name = "unsignedByte")
    protected short memberTwo;

    protected MessageBody messageBody;

    //This member is only needed for marshalling!!!
    @XmlElements({
        @XmlElement(name = "MessageTypeOne",   type = MessageTypeOne.class),
        @XmlElement(name = "MessageTypeTwo",   type = MessageTypeTwo.class),
        @XmlElement(name = "MessageTypeThree", type = MessageTypeThree.class)
    })
    protected MessageType messageBodyChoice;

    //...

    /* 
     * This setter ensures that messageBodyChoice always contains
     * the value of messageBody.getChoice()
     */
    public void setMessageBody(MessageBody messageBody){
        this.messageBody = messageBody;
        if(messageBody != null) 
            this.messageBodyChoice = messageBody.getChoice();
    }

    //...

    void afterUnmarshal(Unmarshaller u, Object parent) { 
        //at this point messageBody is null
        messageBody = new MessageBody();
        messageBody.setChoice(messageBodyChoice);
    }
}