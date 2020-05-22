@Entity    
public class Foo {

    [...]

    @Valid
    @Embedded
    @NotNull
    private Poo poo;
}

@Embeddable
public class Poo {

    @NotNull
    private Double value;

    @NotNull
    private Double value2;

    [...]
}