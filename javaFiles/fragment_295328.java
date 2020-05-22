public void deleteKeepSuperclassObject(final ChildData childData) {
    final BaseData baseDataToKeep = new BaseData();
    //populate baseDataToKeep with data from the childData to remove
    em.persist(baseDataToKeep);
    em.remove(childData);
}