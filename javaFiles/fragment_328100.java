@Entity
@Table(name = "PROTOCOL_FILE")
public class ProtocolFile {

    @Id // No @Column here
    private Long protocolId;

    @MapsId // --- HERE
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name="PROTOCOL_ID") // Just that
    private Protocol protocol;
}