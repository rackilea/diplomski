class OrderedComparator implements Comparator<String> {

    List<String> predefinedOrder;

    public OrderedComparator(String[] predefinedOrder) {
        this.predefinedOrder = Arrays.asList(predefinedOrder);
    }

    @Override
    public int compare(String o1, String o2) {
        return predefinedOrder.indexOf(o1) - predefinedOrder.indexOf(o2);
    }

}