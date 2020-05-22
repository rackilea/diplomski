@Entity
@Table(name="A")
class A {
    @Id
    @Column(name="id")
    private int id;
    String aValue;
    @OneToOne
    B b;
    // Getters, setters and other stuff
}

@Entity
@Table(name="B")
class B {
   @Id
   @Column(name="id")
   private int id;
   Integer Id;
   String bValue;
   // Getters, setters and other stuff
}