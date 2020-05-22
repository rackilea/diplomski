@Document(indexName = "person" , type = "user")

public class Person {

    @Id
    private String id;

    private String name;

    @Field( type = FieldType.Nested)
    private List<Car> car;

    // setters-getters
}