Iterator<Monster> it= Monstre.iterator(); 
while (it.hasNext()) {
    Monster i= it.next();
    //code code code
    if (shouldDelete) {
        this.remove(i);
        it.remove();
    }
}