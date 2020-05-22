@Entity
@Table(name="incident")
public class Incident {
    @Id
    @Column(name="id")
    private Integer id;

    @OneToOne
    @JoinColumn(name="code1")
    private CodeA typeACode;
    @OneToOne
    @JoinColumn(name="code2")
    private CodeB typeBCode;

    public Incident() {}

    public CodeA getTypeACode() { return this.typeACode; }
    public CodeB getTypeBCode() { return this.typeBCode; }
}