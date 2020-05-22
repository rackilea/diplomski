public void update(){
    if(entities.size() > 0){
        LinkedList<Drawable> entities = new LinkedList<>();
        while (it.hasNext()) {
            Drawable d = it.next();
            d.update();
            // Or what ever flag you want to use
            if (d.isRemovable()) {
                it.remove(d);
            }
        }
    }
}