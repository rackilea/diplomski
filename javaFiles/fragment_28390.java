public class Child{
     @OneToMany(mappedBy="child", cascade = CascadeType.PERSIST)
     private List<AnotherChild> anohterChild;

     @ManyToOne
     private Parent parent;
}