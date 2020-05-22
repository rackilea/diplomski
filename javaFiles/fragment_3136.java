@Entity
@Table(name = "FOO")
Foo {

     @OneToOne(cascade = CascadeType.ALL)
     @JoinColumn(name = "BAR_ID")
     private Bar bar;

     // getters and setters
}

@Entity
@Table(name = "BAR")
Bar{

    @OneToOne(mappedBy = "bar")
    private Foo foo;

    // getters and setters
}