public boolean duplicateAll() {
    checkInitialization();
    boolean success = false;
    T[] thisBag = this.toArray();  //not needed anymore
    if(!this.isEmpty()){
        int originalTotalEntries = this.numberOfEntries;
        for(int index = 0; index < originalTotalEntries; index++){
            success = this.add(thisBag[index]);
            numberOfEntries++;
        }
    }
    return success;
}  // end duplicateAll