while (true) {
    Pair<Long, Status> p = dbQ.take();
    List<Pair> collectedPairs = new ArrayList();
    while (p!=null) {
        collectedPairs.add(p);
        p = dbQ.poll();
    }
    orderDao.batchUpdate(collectedPairs);
}