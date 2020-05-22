public class Student extends BaseModel{
    private int id;
    private String name;

    @JsonAdapter(BaseModelForeignKeyTypeAdapterFactory.class)
    private Student goodFriend;

    private Student bestFriend;
}