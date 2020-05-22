public static Comparator<Item> profitByWeightComparator = new Comparator<Item>() {
    @Override
    public int compare(Item item1, Item item2) {
        return Integer.compare(
            item1.getProfit() * item2.getWeight()
        ,   item2.getProfit() * item1.getWeight()
        );
    }
};