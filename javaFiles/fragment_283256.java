public class MyCustomColumnDecorator implements DisplaytagColumnDecorator{

    public Object decorate(Object columnValue, PageContext pageContext, MediaTypeEnum media) {
        return value == null ? "some string" : value;
    }
}