@JsonSubTypes({
    @Type(value=String.class), // String is not a subclass of DetailItem!
    @Type(value=Integer.class) // Integer is not a subclass of DetailItem!
})
public class DetailItem{
}