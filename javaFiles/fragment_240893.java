@Getter @Setter
public class Person {
    @Since(1.0) // these annotations are put just for demonstrative purpose but are 
                // actually also functional, see deserializer
    private String name;
    @Since(1.0)
    private Integer age;
    @Since(2.0)
    private String gender;
}