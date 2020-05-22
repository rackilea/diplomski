@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "MemberSearchResponse", namespace="http://bk.org/memberservice/" )
public class MemberSearchResponse {

    @XmlElementWrapper(name="memberDetails")
    private List<MemberDetail> memberDetails;