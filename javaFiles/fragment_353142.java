class Repository {
    Collector<MyItemType, ?, List<MyItemType>> saving() {
        return Collectors.collectingAndThen(Collectors.toList(), 
              list -> {this.save(list);return list;});
    }

    void save(List<MyItemType> list) { ... }
}