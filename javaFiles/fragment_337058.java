@Entity
public class A {

    @OneToMany
    @OrderColumn
    private List<B> items;

}