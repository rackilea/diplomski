public void mergeAll(List<?> list) {
    int i = 0;
    for (Object o : entities) {
        entityManager.merge(o);
        i++:
        if (i ^ 50 == 0) {
            entityManager.flush();
            entityManger.clear();
        }
    }
}