@Entity
public class Gin extends Model {
    @Id
    @Column(name="idGin")
    private Integer idGin;
    private String aroma;
    ...// some other vars from the database not important

    @ManyToMany
    @JoinTable(name="gin2tonic")
    private List<Tonic> tonics;

        public static Finder<Integer, Gin> find = new Finder<>(
            Integer.class, Gin.class
    );
}


@Entity
public class Tonic extends Model {
    @Id
    @Column(name="idTonic")
    private Integer idTonic;

    private String aroma;

    // some other vars from the database not important


    @ManyToMany(mappedBy = "tonics")
    public List<Gin> gins;                    //changed to Gin type

    public static Finder<Integer, Tonic> find = new Finder<>(
            Integer.class, Tonic.class
    );

}