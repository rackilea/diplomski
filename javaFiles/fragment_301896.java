@Entity
@Table(name = "coop_games")
public class CoopGame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy = "game", fetch = FetchType.EAGER)
    private List<CoopGamesPlayers> players;
}

@Entity
@Table(name = "coop_games_players")
public class CoopGamesPlayers {

    @EmbeddedId
    private PlayerPK pk;

    @JsonBackReference
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "coop_game_id")
    private CoopGame game;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(name = "playerid", referencedColumnName = "id"),
            @JoinColumn(name = "userid", referencedColumnName = "userid")
    })
    @MapsId("id") 
    private Player player;
}