public void display() {
    if(!loaded){
        loadFromDisk(fileName);
        loaded = true;
    }
    //then display
}
public void resize(double scale) {
    if(!loaded){
        loadFromDisk(fileName);
        loaded = true;
    }
    //then resize
}
... // more methods go here
public void save() {
    if(!loaded){
        loadFromDisk(fileName);
        loaded = true;
    }
    //then save
}