// first, copy the array (in this case into a list)
List<Creature> tempList = new ArrayList<>(Arrays.asList(drawArray));

// the index of the next position in the array to insert a creature
int targetIndex = 0;

// fill the array with dead things
for (Creature creature : tempList) {
    if (creature.isDead) {
        drawArray[targetIndex] = creature;
        targetIndex++;
    }
}

// continue filling the array with non-dead things
for (Creature creature : tempList) {
    if (!creature.isDead) {
        drawArray[targetIndex] = creature;
        targetIndex++;
    }
}