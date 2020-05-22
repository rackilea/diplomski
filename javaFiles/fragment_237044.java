@Entity
  @Table(name = "operator")
  public class Operator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonIgnore
    private Long id;

    @NotBlank(message="operator Name cannot be empty")
    @Column(name = "operator_name", nullable = false)
    private String operatorName;

    getters and setters ...

}