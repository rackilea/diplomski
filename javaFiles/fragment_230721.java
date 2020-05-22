@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor(onConstructor=@__(@Deprecated))
public class MyClass {
    private final String field1;
    private final String field2;

    public static MyClass of(String field1, String field2) {
        return new MyClass(field1, field2);
    }
}