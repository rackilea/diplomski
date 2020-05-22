@JsonDeserialize(using = MyClassDeserializer.class)
public class MyClass {

    private Integer id;
    private Category1 category1;
    private Category2 category2;
    private Category3 category3;

}