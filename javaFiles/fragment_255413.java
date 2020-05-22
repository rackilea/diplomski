@Transactional
    public Parent update(Parent parent) {
        Parent newParent = entityManager.merge(parent);
        entityManager.flush();
        entityManager.clear();
        return newParent
    }