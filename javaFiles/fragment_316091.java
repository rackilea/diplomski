public class Item {
    private final int parentId;
    private final int id;

    private final java.util.List<Item> children = new ArrayList<>();

    public Item(int parentId, int id) {
        this.parentId = parentId;
        this.id = id;
    }

    public void addChild(Item child) {
        children.add(child);
    }

    @Override
    public String toString() {
        String result = "id: " + id + ", parent: " + parentId;

        if (children.isEmpty() == false) {
            result += ", children: " + children;
        }

        return result;
    }

    public int getId() {
        return id;
    }

    public int getParentId() {
        return parentId;
    }
}