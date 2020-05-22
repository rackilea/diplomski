public void remove(){
    while(!this.cellsNotComputed.isEmpty()) {
        //if you need to do something with the element, extract 0 and do it.
        cellsNotComputed.remove(0);
    }
}