@Entity
@Table(name = "message_recipients")
public class Recipient {
    @EmbeddedId
    private RecipientId recipientId;

    @MapsId("messageId")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "message_id")
    private Message message;
    public void setMessage(Message msg) {
        this.message = msg;
    }

    public Recipient(Message msg, String name) {
        this.id = new RecipientId(msg, name);
        this.message = msg;
    }

    @Override
    public boolean equals(Object o) { ... }

    @Override
    public int hashCode(Object o) { return key.hashCode(); }
}