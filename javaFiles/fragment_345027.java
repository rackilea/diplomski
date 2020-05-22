Collections.sort(resultList, new Comparator<Item>() {
    @Override
    public int compare(Item lhs, Item rhs) {
        return lhs.getDistance().compareTo(rhs.getDistance());//mungkin valuenya null
    }
});