@Id
@Column(name = "EMP_ID")
private int id;

@OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
@PrimaryKeyJoinColumn(name = "EMP_ID", referencedColumnName = "EMP_ID")
@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.MERGE})
private Employee employee;