public class Bean {
    @NotBlank
    private String name;
}

public class Foo {
    @Valid
    private Bean bean;
}

public class FormObject {
    @Valid
    private Foo foo;
}