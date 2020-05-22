@Entity
class Mother {
  @Id
  Long id;
  @OneToMany(mappedBy="mother")
  Set<Child> children;
}

@Entity
class Child {
  @Id
  Long id; 
  @ManyToOne
  @JoinColumn(name="mother_id")
  Mother mother;
}