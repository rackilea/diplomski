public class FinalClass {
    public ArrayList<ShoppingListItem> shoppingLists;
}

public class ShoppingListItem {
    public ShoppingList ShoppingList;
    @SerializedName("ShoppingItem")
    public List<ShoppingItem> ShoppingItems;
}

public class ShoppingList {
    public int id;
    public String name;
    public String created;
    public String modified;
}

public class ShoppingItem {
   public int id;
   public int shopping_item_category_id;
   public String name;
   public String description;
   public String created;
   public String modified;
   public String category_name;
}