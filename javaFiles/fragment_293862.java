@Entity
public class YourEntity {
    @Id Long id;

    String foo;
    String bar;

    @Index String computed;

    @OnSave void computeComputed() {
        computed = // synthesize from foo and bar
    }
}