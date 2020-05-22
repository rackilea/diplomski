class Parent{
    @OneToMany
    List<Child> children;
}

class Child{
    @ManyToOne
    Parent parent;
}