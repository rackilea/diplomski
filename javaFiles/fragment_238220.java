public void addChild(EntityTwo child) {
    if(child != null) {
        entities.add(child);
        child.setEntityOne(this);
    }
}