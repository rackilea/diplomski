@Entity
public class ExtendedMovie implements Serializable {
    private static final long serialVersionUID = 6771189878622264738L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "cast_id", referencedColumnName = "id")
    private Set<Cast> cast;

    public Set<Cast> getCast() {
        return cast;
    }

    public void setCast(Set<Cast> cast) {
        this.cast= cast;
    }
}