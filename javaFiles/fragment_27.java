class Parent {
   @OneToMany(mappedBy="parent",cascade=CascadeType.ALL)
   private Set<Child> children;
}

class Child {
   @ManyToOne
   private Parent parent;
}