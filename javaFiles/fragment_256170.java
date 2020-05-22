public Figure createInstance(int numSides) {
    Figure figure = null;

    switch(numSides) {
    case 0:
        figure = new Circle();
        break;
    case 3:
        // etc...
        // Make a case for each valid number of sides
        // Don't forget to put a "break;" after each case!
    default:
        // Not a valid shape; print your error message
    }
    return figure;
}