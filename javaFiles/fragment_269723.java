public class SampleDTO {

    @Min(value = 5)
    @Max(value = 10)
    @NotNull
    private Integer integer;

    @NotNull
    private String string;

    //...

}