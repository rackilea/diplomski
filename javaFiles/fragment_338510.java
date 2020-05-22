@Entity
@Table("b_pending")
public class PendingB {
    @Embedded
    private PayloadB payload;
    @Embedded
    private Maker maker;
}

@Entity
@Table("b_approved")
public class ApprovedB {
    @Embedded
    private PayloadB payload;
    @Embedded
    private Maker maker;
    @Embedded
    @AttributeOverrides(value = {
       @AttributeOverride(name="checkerId",column="checker1_id"),
       @AttributeOverride(name="timeApproved",column="checker1_time_approved"),
    })
    private Checker checker1;
    @Embedded
    @AttributeOverrides(value = {
       @AttributeOverride(name="checkerId",column="checker2_id"),
       @AttributeOverride(name="timeApproved",column="checker2_time_approved"),
    })
    private Checker checker2;
}