public class ChildId implements Serializable {  
    String parent; // should have the type of the Id of "parent", according to the JPA spec
    String childStringId;

    // hashCode and equals methods
    ...
}