private void consumeSizeToken(char token) {
    // Obtain the pizza object somewhere, otherwise add it to the
    // method's parameter list.
    switch (token) {
        case 'm':
            // I assume the Pizza class to have a setSize() method.
            pizza.setSize(Size.MEDIUM);
            break;
        case 'l':
            pizza.setSize(Size.LARGE);
            break;
        default:
            throw new IllegalArgumentException("Invalid pizza size");
    }
}

private void consumeToppingToken(char token) {
    // Do the same as the consumeSizeToken() method, but, of course,
    // handle the toppings.
}