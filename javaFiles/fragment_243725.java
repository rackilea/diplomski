public static MinionToy generate() {

        // if (0 < 4)
        //   return a new miniontoy(arra.get(0)
        // the rest of the code never gets executed.
        if (currentToyIndex < arrMinion.size()) {
            return new MinionToy(arrMinion.get(currentToyIndex));

        } else {
            currentToyIndex = 0;
        }
        currentToyIndex++;
        return new MinionToy(arrMinion.get(currentToyIndex));