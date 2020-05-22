@Entity
@Proxy(proxyClass = ICat.class)
@Table(name = "cat")
public class Cat implements ICat {

    @Id
    private Long catId;

    @OneToMany(mappedBy = "cat", fetch = FetchType.LAZY, targetEntity=Cat.class)
    private List<IKitten> kittens;

    ...
}


@Entity
@Proxy(proxyClass = IKitten.class)
@Table(name="kitten")
public class Cat implements IKitten {

    @Id
    private Long kittenId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="catId", targetEntity=Cat.class)
    private ICat cat;

    ...
}