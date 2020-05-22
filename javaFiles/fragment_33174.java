public boolean checkAvailability(SortedListOfImmutables listToCheck) {
    int availableCounter = 0;
    for(int i = 0; i<items.length; i++){ //items is the original array
        if(listToCheck.items[availableCounter].equals(items[i])){
            if (++availableCounter == listToCheck.items.length)
                return true;
        }
    }
    return false;
}