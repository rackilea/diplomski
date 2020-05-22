public void setNameOfAllEntities(String newname){
    List<MyEntity> items =
        entityManager.createQuery("from MyEntity", MyEntity.class)
            .getResultList();
    for(MyEntity entity : items){
        entity.setName(newname);
    }
}