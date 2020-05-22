public void update(){

    List newList = new AppropriateListType(list);
    for (Entity entity : removeList){
        newList.remove(entity);
    }
    removeList.clear(); // Or removeList = new AppropriateListType();
    list = newList;

    for (Entity entity: list) {
        entity.update();
    }
}