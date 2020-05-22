@Entity
class Mother {
  @Id
  Long id;
  @OneToMany(mappedBy="mother", cascading=CascadeType.ALL, orphanRemoval=true)
  Set<Child> children;
}