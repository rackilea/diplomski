public class Foo {

    @NotNull(groups = { Create.class, Evaluate.class })
    private String name;

    ...

    @Min(value = 1, message = "Evaluation value needs to be at least 1", groups = { Evaluate.class })
    private int evaluation;

    ...
}