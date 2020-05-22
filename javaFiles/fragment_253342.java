@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="type")
@JsonSubTypes({
    @Type(name="TYPE_1", value=MySubclass1.class),
    @Type(name="TYPE_2", value=MySubclass2.class)
})
public abstract class MyAbstractClass