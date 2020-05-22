@Entity
@Table(name = "TABLE_A")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MyComplex.findAll", query = "SELECT j FROM MyComplex j"),
    @NamedQuery(name = "MyComplex.findA1", query = "SELECT j FROM MyComplex j WHERE j.a1 = :A1")
})
public class MyComplex implements Serializable {
/* ------------------------------------ */
@OneToOne
@JoinTable(
        name="Table_B",
        joinColumns=
            @JoinColumn(name="A2", referencedColumnName="A2"),
        inverseJoinColumns=
            @JoinColumn(name="B1", referencedColumnName="B1")
    )
private Table_C tableC;
/* ------------ */
}