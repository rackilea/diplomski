@Entity
@Table(name="MotherTable")
class Mother {
  @Id
  Long id;
  @ManyToOne
  @JoinColumn(name="MotherTable_FieldId")
  Child child;
}

@Entity
@Table(name="ChildTable"
class Child {
  @Id
  @Column(name="childTableId")
  Long id; 
  @OneToMany(mappedBy="child")
  Set<Mother> mothers;
}