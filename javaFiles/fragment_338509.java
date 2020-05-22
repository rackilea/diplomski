@Entity
@Table("a_pending")
public class PendingA {
    @Embedded
    private PayloadA payload;
    @Embedded
    private Maker maker;
}

@Entity
@Table("a_approved")
public class ApprovedA {
    @Embedded
    private PayloadA payload;
    @Embedded
    private Maker maker;
    @Embedded
    private Checker checker;
}