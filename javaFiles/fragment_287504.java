@MappedSuperclass
public abstract class BaseVoipCurrentCall implements Serializable {

    @Id
    private CompositeID id;

    private Timestamp startTime;
    private Timestamp endTime;
    private String calledNumber;
    private String callingNumber;    
    private Person contact;
    private CallSource source;
    private CallStatus status;
    private CallType type;
    private CallStage stage;

    // Constructors, getters/setters
}

@Entity
@Table(name = "voip_currentCalls")
public class VoipCurrentCall extends BaseVoipCurrentCall {
    // Voip current call specific attributes and logic
}

@Entity
@Table(name = "voip_historyCalls")
public class VoipHistoryCall extends BaseVoipCurrentCall {
    // Voip history call specific attributes and logic
}