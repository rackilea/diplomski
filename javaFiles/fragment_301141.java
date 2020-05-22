@Entity
    @Table(name="main")
    public class Main implements Serializable {

        @Id
        @GeneratedValue
        @Column(name="main_id")
        int mainId;

        private String mainString;


        @OneToOne(mappedBy = "main", cascade = CascadeType.ALL)  
        Secound second;

        @OneToOne(mappedBy = "main", cascade = CascadeType.ALL)  
        Third Third;
...Getter-setters
}
}