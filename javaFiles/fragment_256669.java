@Entity
@Data
@NoArgsConstructor
@Table(name = "employees")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Employees implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "emp_no", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empNo;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "hire_date")
    private Date hireDate;
}