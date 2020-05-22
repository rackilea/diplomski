@Entity
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    private String codigo;

    private String descricao;

    // must not be @Transient:
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "produto", cascade = {
            CascadeType.REFRESH
        })
    private Estoque estoque;

    // ...    
}

@Entity
@Table(name = "VW_ESTOQUE", schema = "ASICAT")
@Cacheable(value = false)
public class Estoque {

    @Id
    @Column(name = "CD_BEM_SERVICO", nullable = false,
            insertable = false, updatable = false)
    private String codigo;

    @Column(name = "ESTOQUE", insertable = false, updatable = false)
    private Long estoque;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CD_BEM_SERVICO", referencedColumnName = "CODIGO",
        nullable = false, insertable = false, updatable = false, unique = true)
    Produto produto;

    // getters and setters hidden by me
}