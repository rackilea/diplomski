outerLoop:
for(int i = 0 ; i < actorsOnLocation.length()-1 ; i++) {
    Entity actor = actorsOnLocation.get(i);
    // Loop through remaining items (with index greater than current)
    ListIterator<Entity> oppIter = actorsOnLocation.listIterator(i+1);
    while (oppIter.hasNext()) {
        Entity opponent = oppIter.next();
        // Here it's possible that actor or opponent "dies" and
        // should be removed from the list that's being looped
        if (opponent.mustDie()) {
            oppIter.remove();
        } else if (actor.mustDie()) {
            // The following operation invalidates oppIter
            actorsOnLocation.remove(i);
            // so we must continue the outer loop
            continue outerLoop;
        }
    }
}