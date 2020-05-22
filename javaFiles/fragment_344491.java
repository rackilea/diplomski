@Transactional
public void storeList(List<MyEntity> entities) {
    int imported = 0;
    for (MyEntity e: entities) {
        e.persist();
        if (++imported % 50 == 0) {
            e.flush();
            e.clear();
        }
    }
}