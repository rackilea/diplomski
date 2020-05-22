class ItemNumComparator implements Comparator<Item> {
    @Override
    public int compare(Item a, Item b) {
        return (a.num < b.num) ? -1 : ((a.num == b.num) ? 0 : 1);
    }
}