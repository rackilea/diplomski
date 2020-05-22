@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public College {
    @Id   
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int cId;
    private String collegeName;
    private int numOfStudent;

    @OneToMany(mappedBy="college", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Student> studentList = new ArrayList<>();
}