public void play() {

    for (int i = 0; i < 5; i++) {
        addNewObjectWithCoordinates();
        System.out.println(getCoordinate(0).getX());

        // sleep thread 
    }
}