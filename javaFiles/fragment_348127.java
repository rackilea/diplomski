Collections.sort(items, new Comparator<Item>()
{
    @Override
    public int compare(Item o1, Item o2)
    {
        if (o1.getPrice() == 999 && o1.getPrice() < o2.getPrice()) {
            return 1;
        }
        if (o2.getPrice() == 999) {
            return -1;
        }
        return Double.compare(o1.getPrice(), o2.getPrice());
    }
});