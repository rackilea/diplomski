@Entity
@Table("team")
public class Team {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String name;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    List<Player> players = new ArrayList<>();
}

@Entity
@Table("player")
public class Player {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch=FetchType.LAZY, optional = false)
    @JoinColumn("team_id")
    Team team;

    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    String position;
}