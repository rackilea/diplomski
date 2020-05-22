@Entity
@SecondaryTable(name = "VW_ESTOQUE", schema = "ASICAT"
        pkJoinColumns = {
            @PrimaryKeyJoinColumn(name = "CD_BEM_SERVICO",
                    referencedColumnName = "CODIGO") })
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    private String codigo;

    private String descricao;

    @Column(name = "ESTOQUE", table = "VW_ESTOQUE", nullable = true,
            insertable = false, updatable = false)
    private Long estoque;

    // ...
}