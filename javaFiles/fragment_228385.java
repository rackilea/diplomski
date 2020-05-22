public static void main(String[] args) {
    List<Item> list = new ArrayList<>();
    Map<Boolean, Long> map = 
        list.stream()
            .collect(Collectors.partitioningBy(
                Item::condition, 
                Collectors.summingLong(Item::asLong)
            ));
    long sumWithTrueCondition = map.get(true);
    long sumWithFalseCondition = map.get(false);
}