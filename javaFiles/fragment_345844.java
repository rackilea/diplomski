@JsonTypeInfo( use = JsonTypeInfo.Id.NAME, include = As.PROPERTY, property = "type" )
@JsonSubTypes( { @Type( value = FirstClass.class, name = "first" )
                ,@Type( value = SecondClass.class, name = "second" )
                ,@Type( value = ThirdClass.class, name = "third" ) } )
@JsonTypeName("forth")
public class Master {

    public String name;
}