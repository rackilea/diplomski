public class Car {
    private int id;
    private String name;
    //Supresses serialization of this property when another view is active
    @JsonView(View.Full.class)
    private String description;

    ......
}