@DatabaseTable
public class User {
    public final static String ITEM_COLUMN_NAME = "item";
    ...
    @DatabaseField(columnName = ITEM_COLUMN_NAME, canBeNull = false,
         foreign = true, unique = true)
    private Item item;