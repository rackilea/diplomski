public class Comment{

    @NotEmpty
    @Length(max = 140)
    private String text;

    //Methods are omitted.
}