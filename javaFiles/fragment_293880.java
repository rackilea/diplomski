private final Map<Paint, Paint> fills = new HashMap<>();

// ...

    fills.put(Color.RED, Color.GREEN);
    fills.put(Color.GREEN, Color.BLUE);
    fills.put(Color.BLUE, Color.RED);

// ...

private void makeRGB(Circle c) {
    makeRGB(c::getFill, c:setFill);
}

private void makeRGB(Scene s) {
    makeRGB(s::getFill, s:setFill);
}

private void makeRGB(Supplier<Paint> currentFill, Consumer<Paint> updater) {

    Timeline timeline = new Timeline(Duration.millis(RGB_CHANGE_PERIOD), 
        e-> updater.accept(fills.get(currentFill.get())));
    timeline.setCycleCount(Animation.INDEFINITE);
    timeline.play();
}