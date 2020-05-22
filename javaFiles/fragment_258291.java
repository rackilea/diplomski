public static Comparator<Item> profitByWeightComparator = new Comparator<Item>() {
    @Override
    public int compare(Item item1, Item item2) {
        double item1Ratio = ((double)item1.getProfit())/item1.getWeight();
        double item2Ratio = ((double)(item2.getProfit())/item2.getWeight();
        return Double.compare(item1Ratio, item2Ratio);
    }
};