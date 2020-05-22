@Entity(name = "GARDEN")
public class Garden {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "NAME", nullable = false)
    private String name; // "Oak Grove"

    // use this if you don't want a bi-directional relationship
    // @OneToMany
    // @JoinColumn(name = "ID", referencedColumnName="GARDEN_ID")
    // private List<Plant> plants;

    // use this if you want it bi-directional
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "garden")
    private Set<Plant> plants;
}

@Entity(name = "PLANT")   
public class Plant {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "NAME", nullable = false)
    private String name; // "Cherry Tomato"

    // use this if you don't want a bi-directional relationship
    // @Column(name="GARDEN_ID")
    // private long gardenId;

    // use this if you want a bi-directional relationship
    @ManyToOne
    @JoinColumn(name = "GARDEN_ID", referencedColumnName="ID", nullable = false)
    private Garden garden;

}