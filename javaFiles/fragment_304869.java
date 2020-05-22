@Entity
@Table(name="MARITAL_STATUS")
Class MaritalStatus(){
    @Id
    @Column(name = "ID", unique = true, nullable = false, precision = 15, scale = 0)
    private Long id;

    @OneToMany(mappedBy="maritalStatus")
    Set<Person> persons;
}