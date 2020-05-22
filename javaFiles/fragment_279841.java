@XmlRootElement(name = "FNOL")
@XmlAccessorType(XmlAccessType.FIELD)
public class ConversationXML {

    @XmlElement
    ParticipantList participantList;
    @XmlElement
    KeyActionsXML keyActions;
    @XmlElement
    LossDetailsXML lossDetails;
    @XmlElement
    AdditionalLossDetailsXML addLossDetails;
    @XmlElement
    PolicyDetailsXML policyDetails;

    //getter setter

}

public class ParticipantList {

    @XmlElement(name = "Participant")
    List<ParticipantsXML> participants;

    @XmlAttribute 
    String inv;

    @XmlAttribute
    String v;

    ...
}