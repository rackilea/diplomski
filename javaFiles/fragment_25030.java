@Entity
class Mother {
  @Id
  Long id;
  @OneToMany(mappedBy="mother", cascading=CascadeType.ALL)
  Set<Child> children;
}