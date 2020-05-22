@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Folder.class, name = "folder")
        @JsonSubTypes.Type(value = File.class, name = "file")
})
public abstract class Component implements IComponent{
    //...
}