@Entity
public class EdgeInnovation {
    @Id
    public long id;
    @Column(name="DESTINATION_ID", updatable=false, insertable=false)
    public Long destination_id;
    @ManyToOne
    public NodeInnovation destination;
    @Column(name="ORIGIN_ID", updatable=false, insertable=false)
    public Long origin_id;
    @ManyToOne
    public NodeInnovation origin;
}