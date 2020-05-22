public void update(){
    synchronized (list) {
        for (Entity entity: removeList){
            list.remove(entity);
        }
    }
    removeList.clear();

    for (Entity entity: list) {
        // This is probably fine depending on how `render` and `update` work
        // but you *may* need to `synchronize` on `entity` (here and in `render`
        // depending on how `render` and `update` work
        entity.update();
    }
}