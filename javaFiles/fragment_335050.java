public void moveStock(Warehouse from, Warehouse to, int nof) {
    List<Lock> locks = Stream.of(from, to)
        .sorted(Comparator.comparingInt(Warehouse::getNumber))
        .map(Warehouse::getLock)
        .collect(Collectors.toList());

    for(int i=0;i<locks.size();++i) {
        locks.get(i).lock();
    }
    try {
        from.substractStock(nof);
        to.addStock(nof);
    } finally {
        for(int i=locks.size()-1;i>=0;i--) {
            locks.get(i).unlock();
        }
    }
}