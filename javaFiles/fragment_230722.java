@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class MyClass {
    private final String field1;
    private final String field2;

    /**
     * @deprecated Will be removed in the future.
     *    Use {@link #MyClass(String, String)} instead 
     */
    @Deprecated
    public static MyClass of(String field1, String field2) {
        return new MyClass(field1, field2);
    }
}