@Entity
public class EdgeInnovation {
    @Id
    public long id;
    @Column(name="DESTINATION_ID")
    public Long destination;
    @Column(name="ORIGIN_ID")
    public Long origin;
}