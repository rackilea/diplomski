private Parent createBookingFlow() {
    BookingModel model = new BookingModel() ;
    model.setScreen(Screen.ARRIVAL);
    ControllerFactory controllerFactory = new ControllerFactory(model);
    BorderPane flow = new BorderPane();

    Node arrivalScreen = load("arrival/Arrival.fxml", controllerFactory);
    Node departureScreen = load("departure/Departure.fxml", controllerFactory);
    Node confirmationScreen = load("confirmation/Confirmation.fxml", controllerFactory);

    flow.centerProperty().bind(Bindings.createObjectBinding(() -> {
        switch (model.getScreen()) {
            case ARRIVAL: return arrivalScreen ;
            case DEPARTURE: return departureScreen ;
            case CONFIRMATION: return confirmationScreen ;
            default: return null ;
        }
    }, model.screenProperty()));

    return flow ;
}

private Node load(String resource, ControllerFactory controllerFactory) {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(resource));
        loader.setControllerFactory(controllerFactory);
        return loader.load() ;
    } catch (IOException exc) {
        throw new UncheckedIOException(exc);
    }
}