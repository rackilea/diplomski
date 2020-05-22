public static void main(String[] args) {
    List<Item> items = new ArrayList<>();
    items.add(new Item(2, "ball"));
    items.add(new Item(5, "cow"));
    items.add(new Item(3, "gum"));

    Comparator<Item> itemNumComparator = new ItemNumComparator();
    Collections.sort(items, itemNumComparator);

    // Pass a dummy object containing only the relevant attribute to be searched
    int index = Collections.binarySearch(items, new Item(5, ""), itemNumComparator);
    Item removedItem = null;
    // binarySearch will return -1 if it does not find the element.
    if (index > -1) {
        // This will remove the element, Item(5, "cow") in this case, from the list
        removedItem = items.remove(index);
    }
    System.out.println(removedItem);
}