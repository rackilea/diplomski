public class ContractHistory extends implements Serializable {
private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;

@ManyToOne(optional = false)
@JoinColumn(name="ID_COMPANY_CONTRACT", nullable = true)
private CompanyContract companyContract;

...
}