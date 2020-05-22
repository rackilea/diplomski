@XStreamAlias("Cat")
public class Cat {

    int age;
    String name;

    @XStreamAlias("Cat")
    Cat anotherSmallCat;

}