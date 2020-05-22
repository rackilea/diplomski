public static MinionToy generate() {

        if (currentToyIndex >= arrMinion.size()) {
            currentToyIndex = 0;
        }
        return new MinionToy(arrMinion.get(currentToyIndex++));
 }