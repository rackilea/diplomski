int nbPrio=0;
ListIterator<T> it = this.iterateur();
while(it.hasNext()){
    if(it.next().obtenirPriorite() == priorite){
        nbPrio++;
    }
}
return nbPrio;