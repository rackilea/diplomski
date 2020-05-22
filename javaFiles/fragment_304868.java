@Entity
@Table(name="PERSON")
Class Person(){
    @Id
    @Column(name = "ID", unique = true, nullable = false, precision = 15, scale = 0)
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="MARITAL_STATUS_ID")
    MaritalStatus maritalStatus;
}