public static class CellData {
    private final StringProperty data;

    private final ReadOnlyDoubleWrapper secondsRemaining;

    private final Timeline timeline = new Timeline();

    public CellData(Consumer<? super CellData> finished) {
        data = new SimpleStringProperty(this, "data");
        secondsRemaining =
            new ReadOnlyDoubleWrapper(this, "secondsRemaining");

        data.addListener((o, oldData, newData) -> {
            try {
                double startTime = Double.parseDouble(newData);

                timeline.stop();

                timeline.getKeyFrames().setAll(
                    new KeyFrame(Duration.ZERO,
                        new KeyValue(secondsRemaining, startTime)),
                    new KeyFrame(Duration.seconds(startTime),
                        new KeyValue(secondsRemaining, 0.0))
                );
                timeline.setOnFinished(e -> finished.accept(this));

                timeline.play();
            } catch (NumberFormatException e) {
                System.err.println(
                    "Cannot start timer for invalid seconds value: " + e);
                Platform.runLater(() -> finished.accept(this));
            }
        });
    }

    public CellData(String data,
                    Consumer<? super CellData> finished) {
        this(finished);
        this.setData(data);
    }

    public StringProperty dataProperty() {
        return data;
    }

    public String getData() {
        return data.get();
    }

    public void setData(String data) {
        this.data.set(data);
    }

    public ReadOnlyDoubleProperty secondsRemainingProperty() {
        return secondsRemaining.getReadOnlyProperty();
    }

    public double getSecondsRemaining() {
        return secondsRemaining.get();
    }
}