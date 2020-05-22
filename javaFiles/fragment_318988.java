@MappedSuperClass
public class Foo {
    private Long id;
    // ... getters and setters
}

@Table("BAR")
@AttributeOverride(name="id" column=@Column(name = "BAR_ID"))
public class Bar extends Foo {
    // ... map your table
}