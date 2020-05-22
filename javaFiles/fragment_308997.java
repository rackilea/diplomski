@Table
public class FooBar {
    @EmbeddedId
    public PrimaryKey compositeKey;

    @Column(name = "value")
    public int value;

    @Embeddable
    public static class PrimaryKey implements Serializable {
        @Column(name = "id")
        public String id;

        @Column(name = "fooBarType")
        @Convert(converter = FooBarType.Converter.class)
        public FooBarType fooBarType;
    }
}