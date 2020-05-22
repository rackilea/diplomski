@Entity
public class Parent {

    @OneToOne(fetch=FetchType.LAZY)
    private Child child;

}