Object item = null;
Object itemName = null;

if (itemc.getClass().equals(ItemTool)) {
    item = (ItemTool) itemc;
    itemName = item.name;
} else {
    if (itemc.getClass().equals(ItemFood)) {
        item = (ItemFood) itemc;
        itemName = item.name;
    }
}

registerItem(item, itemName);