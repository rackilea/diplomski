@Entity
@Table(name="GiganticEntity")
@Immutable
public class GignaticBazViewEntity {

    @Id Long id;

    @OneToOne(mappedBy = "bar")
    Bar bar;

    @OneToOne(mappedBy = "baz")
    Baz baz;

    public GiganticEntity(Long id, Bar bar, Baz baz) {
        this.id = id;
        this.bar = bar;
        this.baz = baz;
    }
}