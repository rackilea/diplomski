ArrayList<Turtle> results = new ArrayList<Turtle>();

for (int i = 0; i < nrTurtles; i++) {

    if (turtles.get(i).getX() == 450) {

        results.add(turtles.get(i));
    }
}

if (results.size() == 0) {

    // No turtles are at 450

} else if (results.size() == 1) {

    // Turtle is alone at 450

} else {

    // Turtles are all at 450
}