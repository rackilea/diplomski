ListIterator<Phase> iterator = phaseList.listIterator();
while(iterator.hasNext()){
    Phase phase = iterator.next();
    if(phase.getId().toString().equalsIgnoreCase(idPhaseToBeReplaced)){ 
        iterator.set(replacementPhase);
        break;
    }
}