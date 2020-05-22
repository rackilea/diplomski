public abstract class A{
   ...
   @OneToOne(mappedBy = "a") 
   private Foo foo;
   ...
}

public class Foo{
    ...
    @OneToOne
    @JoinColumn(name = "a_id",  nullable = false)
    private A a
    ...
 }