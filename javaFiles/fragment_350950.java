@Entity
@Table(name = "params")
public class Tparam implements Serializable
{
    @Id
    @GeneratedValue
    @Column(name = "p_id")
    private int id;

    @Column(name = "name")
    private String Name;

    @Column(name = "text")
    private String visibleText

    ...
}

@Entity
@Table(name = "lang")
public class Lang implements Serializable
{
    @Id
    @GeneratedValue
    @Column(name = "lang_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "p_id")
    private Tparam param;

    ...
}

@Entity
@Table(name = "site")
public class Site implements Serializable
{
    @Id
    @GeneratedValue
    @Column(name = "site_id")
    private int id;


    @ManyToOne
    @JoinColumn(name = "lang_id")
    private Lang lang

    ...
}