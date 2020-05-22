@Entity
@Table(name = "ADDRESS")
@DiscriminatorValue(value="2")
public class PostalAddress extends Address {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "INSURED_ID")
    private Insured insured;

    public void setInsured(Insured insured) {
        this.insured = insured;
    }

    public Insured getInsured() {
        return insured;
    }

}