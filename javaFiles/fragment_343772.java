@Embeddable
public class ProcId implements Serializable {
    @ManyToOne(optional = false)
    private Article article;
    @ManyToOne(optional = false)
    private Supplier supplier;
}