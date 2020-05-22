@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public Student {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int sId;
    private String name;
    private String city;

    //student table has a FK column college_id 
    @ManyToOne
    @JoinColumn(name = "college_id")
    private College college;
}