public class Parent { 
    @OneToMany(mappedBy = parent, cascade = CasacadeType.ALL, orphanRemoval = true) 
    private Set<Child> children = new HashSet<>();

    public void removeChild(Child child) {
        children.remove(child);
        child.setParent(null);
    }
}

public class Child {
    @ManyToOne
    private Parent parent;
}