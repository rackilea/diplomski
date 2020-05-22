public void removeDeathObjects() {
    Wand tempW;
    Gegner tempG;
    for (Iterator<Gegner> it = gegner.iterator(); it.hasNext();) {
        tempG = it.next();
        if (tempG.isDeath()){
            it.remove();
        }
    }
    for (Iterator<Wand> it2 = waende.iterator(); it2.hasNext();) {
        tempW = it2.next();
        if(tempW.isDestroyed()){
            it2.remove();
        }
    }   
}