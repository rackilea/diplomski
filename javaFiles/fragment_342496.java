public Rock nextRock() {
    for (int counter = 0; counter < rocks.length; counter++) {
        if (!rocks[counter].hasBeenUsed) {
            return rocks[counter];
        }
    }
    return null;
}