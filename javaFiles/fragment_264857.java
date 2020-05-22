public class Data implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    private String url;
    private String status;

    @OneToOne(cascade=CascadeType.ALL)
    private Student student;
}