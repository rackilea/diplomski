public class Items {
    @XmlName("item")
    @XmlAbstractClass(tag="type", types={
        @TypeMap(name="board", type=Board.class),
        @TypeMap(name="role", type=Role.class),
        @TypeMap(name="person", type=Person.class)
    })
    public List<Item> items;
}

abstract class Item {
    @XmlName("content_id")
    public Integer contentId;
}
public class Board extends Item {
    String abn;
}
public class Role extends Item {
    @XmlNoExport
    @XmlName("role_belongs_to")
    Integer boardId;
    @XmlNoImport
    @XmlWrapperTag("role_belongs_to")
    Board board;
}
public class Person extends Item {
    @XmlNoExport
    @XmlName("has_role")
    public Integer hasRole;
    @XmlNoImport
    public Role role;
}

@XmlName("items")
public class PersonList {
    @XmlName("Person")
    public List<Person> persons;
}