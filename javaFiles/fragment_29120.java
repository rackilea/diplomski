List<Integer> intList = new ArrayList<>();
Comparator<Integer> intComparator = new Comparator<Integer>() {
    @Override
    public int compare(Integer left, Integer right) {
        return left.compareTo(right);
    }
}

sort(intList, intComparator);