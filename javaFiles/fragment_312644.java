@Entity
public ClassB {
    ...
    @ManyToOne
    ClassA classA;
    ...
}