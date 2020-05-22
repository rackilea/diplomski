@Entity
public class Client{

    @Id
    @Column(name="CLNT_ID") 
    private long key;
    @Column(name="CLNT_NUM")
    private String clientNumber;
...
}