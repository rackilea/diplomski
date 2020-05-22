public SearchableByIndex searchByIndex(int index) {
    if (getIndex() == index) {
        return this;
    } else {
        for (Party party : parties) {    // or Creature creature : members etc.
            SearchableByIndex found = party.searchByIndex(index);
            if (found != null) {
                return found;
            }
        }
    }
    return null;
}