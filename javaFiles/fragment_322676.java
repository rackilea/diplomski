Comparator<ItemLocation> titleComparator = new Comparator<ItemLocation>() {
    @Override
    public int compare(ItemLocation o1, ItemLocation o2) {
        return o1.title.compareTo(o2.title);
    }
}

Comparator<ItemLocation> idComparator = new Comparator<ItemLocation>() {
    @Override
    public int compare(ItemLocation o1, ItemLocation o2) {
        return Integer.valueOf(o1.id).compareTo(o2.id);
    }
}

public void sort(final String field, List<ItemLocation> itemLocationList) {

    final Comparator<ItemLocation> comparator;

    if(field.equals("title")) {
        comparator = titleComparator;
    } else if (field.equals("id")) {
        comparator = idComparator;
    } else {
        throw new IllegalArgumentException("Comparator not found for " + field);
    }

    Collections.sort(itemLocationList, comparator);
}