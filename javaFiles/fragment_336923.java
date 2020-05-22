public class Product{
    private Long id;
    private String name;
    private Double price;

    //constructors, getters, setters
}

public class Person{
    private Long id;
    private String name;
    private String mail;

    //constructors, getters, setters
}

public class Entity{
    private Person person;
    private List <Product> products;

    //constructors, getters, setters
}