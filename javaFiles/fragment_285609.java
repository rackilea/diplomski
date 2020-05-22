@Entity
@Table(name = "mytable", schema = "myschema")
@IdClass(ClientPK.class)
public class Client {

    @Column(name = "clientid")
    @Id
    private Integer clientid;

    @Column(name = "client")
    private Integer client;

    @Column(name = "name")
    private String name;
}