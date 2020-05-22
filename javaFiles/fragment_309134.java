@PrePersist
private void generateId() {

    if(id>0){
        return;
    }
    id=++type.lastChronoId;
    type.save();
}