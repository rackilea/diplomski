public class ItemSet {
    private final ArrayList<Item> items = new ArrayList<Item>();
    private ItemClass itemClass;

    public ItemSet(Item item) {
        items.add(item);
    }

    public boolean add(Item e) {
        boolean isNotAdded = true;
        for (Item item : items)
            if (e.getRule().compareTo(item.getRule()))
                if (e.getDot() == item.getDot()) {
                    isNotAdded = false;
                    break;
                }
        // why are you adding here?
        if (isNotAdded)
            items.add(e);
        return isNotAdded;
    }

    public Item get(int index) {
        return items.get(index);
    }

    public int size() {
        return items.size();
    }

    public void setItemClass(ItemClass itemClass) {
        this.itemClass = itemClass;
    }

    public ItemClass getItemClass() {
        return itemClass;
    }
}
}