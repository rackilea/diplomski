public class Utente implements Serializable{
    .......    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_utente", unique = true, nullable = false)
    private Integer idUtente;    
    .......

    @OneToOne(mappedBy = "utente")
    private Autenticazione autenticazione;