@JsonTypeInfo(  
        use = JsonTypeInfo.Id.NAME,  
        include = JsonTypeInfo.As.PROPERTY,  
        property = "folder",
        defaultImpl = FolderTree.class)
public class FolderMixin {

}