public void consolidate() {
    Alien newAlienArray[] = new Alien[cockpitCrew.length];
    int front = 0;
    int rear = cockpitCrew.length - 1;
    for (int index = 0; index < cockpitCrew.length; index++) {
        if (cockpitCrew[index] == null) {
            newAlienArray[rear] = cockpitCrew[index];
            rear--;
        } else {
            newAlienArray[front] = cockpitCrew[index];
            front++;
        }
    }
    cockpitCrew = newAlienArray;// if you finally need to replace the new order in cockpitCrew
}