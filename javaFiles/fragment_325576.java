@Entity
public class A {
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "ID_B")
    private B b;
}

@Entity
public class B {
    //no reference to A
}