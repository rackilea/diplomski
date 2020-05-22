@BelongsToContract(AnchorStateContract.class)
public class AnchorState implements LinearState {

    public String ownerId,contentHash,description,classid,timestamp,expiry;
    public Party initiatorParty, otherParty;
    public UniqueIdentifier linearId;

    @Override
    public List<AbstractParty> getParticipants() {
        return Arrays.asList(initiatorParty, otherParty);
    }

    public AnchorState() {
    }

    @ConstructorForDeserialization
    public AnchorState(String ownerId, String contentHash, String description, String classid, String timestamp, String expiry, Party initiatorParty, Party otherParty, UniqueIdentifier linearId) {
        this.ownerId = ownerId;
        this.contentHash = contentHash;
        this.description = description;
        this.classid = classid;
        this.timestamp = timestamp;
        this.expiry = expiry;
        this.initiatorParty = initiatorParty;
        this.otherParty = otherParty;
        this.linearId = linearId;
    }
...