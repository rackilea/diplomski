@Entity
@Table(name = "audit_revisions")
@SequenceGenerator(name = "seq_gen", sequenceName = "audit_revisions_seq", allocationSize = 1)
@RevisionEntity
@EntityListeners(AuditingEntityListener.class)
@Getter
public class AuditRevision {
    @Id
    @GeneratedValue(generator = "seq_gen", strategy = SEQUENCE)
    @RevisionNumber
    private Long id;

    @RevisionTimestamp
    private Date revisionDate;

    @CreatedBy
    private String createdBy;
}