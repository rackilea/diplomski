@XStreamAlias("message")
class RendezvousMessage {

    @XStreamOmitField
    private int messageType;

    @XStreamImplicit(itemFieldName="part")
    private List<String> content;

    @XStreamConverter(SingleValueCalendarConverter.class)
    private Calendar created = new GregorianCalendar();

    public RendezvousMessage(int messageType, String... content) {
        this.messageType = messageType;
        this.content = Arrays.asList(content);
    }
}