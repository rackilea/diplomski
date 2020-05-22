@Entity
class Table1 {
  @Id
  @Column(name="T1_ID")
  long id;

  @OneToOne// also works with @ManyToMany
  @JoinTable(name="Table2", 
             joinColumns={@JoinColumn(name="T1_ID")},
             inverseJoinColumns={@JoinColumn(name="T3_ID")}
  Table3 table3;
...
}



@Entity
class Table3 {
  @Id
  @Column(name="T3_ID")
  long id;
  ...
}