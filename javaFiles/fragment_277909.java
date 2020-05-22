@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")  
@JsonSubTypes({  
    @Type(value = B.class, name = "b"),  
    @Type(value = B.class, name= "c")
    })  
class A {
}