@JsonTypeInfo(  
    use = JsonTypeInfo.Id.NAME,  
    include = JsonTypeInfo.As.PROPERTY,  
    property = "kind",
    visible = true,                    // <----- add this
    defaultImpl = EntityBase.Impl.class
    )
public abstract class EntityBase {
    ...
}