@Entity
public class Emoji implements Serializable  {

private static long serialVersionUID = 1L;

public static long getSerialVersionUID() {
    return serialVersionUID;
}

public static void setSerialVersionUID(long aSerialVersionUID) {
    serialVersionUID = aSerialVersionUID;
}
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
@ManyToOne
private Utilisateur createur;
private String titre;
@OneToMany(cascade = CascadeType.PERSIST)
private List<Message> conversations;
}