int indexOfDeadGuy = -1;
for (int i=0; i<drawArray.length; i++) {
    if (drawArray[i].isDead) {
        indexOfDeadGuy = i;
        break;
    }
}