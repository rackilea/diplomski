public void tick() {
    for(int i=0; i < handler.object.size() ;i++) {
        GameObject tempObject = handler.object.get(i);
        if (tempObject.getId() == ID.FlashCardCover){
            //run a method in FlashCardCover class on this individual object
        }
    }   
}